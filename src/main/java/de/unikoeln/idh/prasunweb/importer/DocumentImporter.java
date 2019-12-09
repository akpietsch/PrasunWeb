package de.unikoeln.idh.prasunweb.importer;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import de.unikoeln.idh.prasunweb.model.Book;
import de.unikoeln.idh.prasunweb.model.Footnote;
import de.unikoeln.idh.prasunweb.model.Section;
import de.unikoeln.idh.prasunweb.model.Sentence;
import de.unikoeln.idh.prasunweb.service.book.BookService;

@Component
@Transactional
public class DocumentImporter {

    @Autowired
    private Environment env;

    @Autowired
    private BookService books;

    private XWPFDocument document;

    private Logger logger = LoggerFactory.getLogger(DocumentImporter.class);

    private final String footnote = "\\[footnoteRef:([0-9]+)\\]";

    private final String splitter = " ?[0-9]+\\. ?";

    private final String start = "^Prasun-Texte von [0-9]{4}$";

    private final String stop = "^\n$";

    @EventListener(ApplicationReadyEvent.class)
    public void executeImporter() {
        boolean parse = this.env.getProperty("prasunweb.data.parse", Boolean.class);
        File source = new File(env.getProperty("prasunweb.data.source"));

        if (parse && source.exists()) {
            this.logger.info("Starting document import from " + source.getAbsolutePath());

            for (Entry<String, List<List<XWPFParagraph>>> bookTexts : this.getBookTexts().entrySet()) {
                Book book = new Book();
                List<Section> sectionsGerman = new ArrayList<Section>();
                List<Section> sectionsPrasun = new ArrayList<Section>();

                for (List<XWPFParagraph> text : bookTexts.getValue()) {
                    Section section = new Section();

                    for (XWPFParagraph paragraph : text) {
                        for (Sentence sentence : this.getSentences(paragraph)) {
                            if (section.getTitle() == null) {
                                section.setTitle(sentence);

                                switch (paragraph.getStyleID()) {
                                case "german-head":
                                    section.setLocale("deu");
                                    break;

                                case "prasun-head":
                                    section.setLocale("prn");
                                    break;
                                }
                            } else {
                                section.addSentences(sentence);
                            }
                        }
                    }

                    switch (section.getLocale()) {
                    case "deu":
                        sectionsGerman.add(section);
                        break;

                    case "prn":
                        sectionsPrasun.add(section);
                        break;
                    }
                }

                for (int i = 0; i < sectionsGerman.size() || i < sectionsPrasun.size(); i++) {
                    sectionsGerman.get(i).getSections().add(sectionsPrasun.get(i));
                    sectionsPrasun.get(i).getSections().add(sectionsGerman.get(i));
                }

                book.addSections(sectionsGerman.toArray(new Section[sectionsGerman.size()]));
                book.addSections(sectionsPrasun.toArray(new Section[sectionsPrasun.size()]));
                book.setTitle(bookTexts.getKey());
                this.books.save(book);
            }

            this.logger.info("Completed document import");
        }
    }

    private XWPFDocument getDocument() {
        if (this.document == null) {
            ZipSecureFile.setMinInflateRatio(0);
            String source = env.getProperty("prasunweb.data.source");

            try (XWPFDocument docx = new XWPFDocument(new FileInputStream(source))) {
                this.document = docx;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return this.document;
    }

    private Map<String, List<XWPFParagraph>> getBooks() {
        Map<String, List<XWPFParagraph>> books = new HashMap<String, List<XWPFParagraph>>();
        List<XWPFParagraph> paragraphs = this.getDocument().getParagraphs();

        for (int i = 0; i < paragraphs.size(); i++) {
            String text = paragraphs.get(i).getParagraphText().trim();

            if (text.matches(this.start)) {
                List<XWPFParagraph> book = new ArrayList<XWPFParagraph>();

                while (!paragraphs.get(++i).getParagraphText().matches(this.stop)) {
                    book.add(paragraphs.get(i));
                }

                books.put(text, book);
            }
        }

        return books;
    }

    private Map<String, List<List<XWPFParagraph>>> getBookTexts() {
        Map<String, List<List<XWPFParagraph>>> bookTexts = new HashMap<String, List<List<XWPFParagraph>>>();

        for (Entry<String, List<XWPFParagraph>> book : this.getBooks().entrySet()) {
            List<List<XWPFParagraph>> texts = new ArrayList<List<XWPFParagraph>>();
            List<XWPFParagraph> textGerman = new ArrayList<XWPFParagraph>();
            List<XWPFParagraph> textPrasun = new ArrayList<XWPFParagraph>();

            for (XWPFParagraph paragraph : book.getValue()) {
                if (paragraph.getStyleID() != null) {
                    switch (paragraph.getStyleID()) {
                    case "german-head":
                        if (textGerman.size() > 0) {
                            texts.add(textGerman);
                            textGerman = new ArrayList<XWPFParagraph>();
                        }

                        textGerman.add(paragraph);
                        break;

                    case "german-body":
                        textGerman.add(paragraph);
                        break;

                    case "prasun-head":
                        if (textPrasun.size() > 0) {
                            texts.add(textPrasun);
                            textPrasun = new ArrayList<XWPFParagraph>();
                        }

                        textPrasun.add(paragraph);
                        break;

                    case "prasun-body":
                        textPrasun.add(paragraph);
                        break;
                    }
                }
            }

            if (textGerman.size() > 0) {
                texts.add(textGerman);
            }

            if (textPrasun.size() > 0) {
                texts.add(textPrasun);
            }

            bookTexts.put(book.getKey(), texts);
        }

        return bookTexts;
    }

    private List<Sentence> getSentences(XWPFParagraph paragraph) {
        List<Sentence> sentences = new ArrayList<Sentence>();

        for (String string : paragraph.getParagraphText().trim().split(this.splitter)) {
            if (string.trim().length() > 0) {
                Matcher matcher = Pattern.compile(this.footnote).matcher(string.trim());
                Sentence sentence = new Sentence();
                int zoffset = 0;

                while (matcher.find()) {
                    Footnote footnote = new Footnote();
                    footnote.setPostition(matcher.start() - zoffset);
                    footnote.setContent(this.getDocument()
                                            .getFootnoteByID(Integer.parseInt(matcher.group(1)))
                                            .getParagraphs()
                                            .stream()
                                            .map(p -> p.getParagraphText().trim())
                                            .collect(Collectors.joining(" ")));

                    zoffset += matcher.end() - matcher.start();
                    sentence.addFootnote(footnote);
                }

                sentence.setContent(string.trim().replaceAll(this.footnote, ""));
                sentences.add(sentence);
            }
        }

        return sentences;
    }

}
