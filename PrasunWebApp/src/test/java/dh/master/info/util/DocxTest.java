
package dh.master.info.util;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.junit.Test;

public class DocxTest {

	private final String source = "C:/Users/Anne/Desktop/Masterarbeit/raw/Degener Budruss 2015 - Materialien zur Prasun-Sprache des afghanischen Hindukusch  Band 1 Texte und Glossar.docx";

	@Test
	public void parseDocxParagraphs() {
		ZipSecureFile.setMinInflateRatio(0);
		List<String> paragraphs = new ArrayList<>();

		try (XWPFDocument xdoc = new XWPFDocument(new FileInputStream(this.source))) {
			new ArrayList<XWPFTable>(xdoc.getTables()).forEach(table -> {
				xdoc.removeBodyElement(xdoc.getPosOfTable(table));
			});

			List<XWPFParagraph> main = xdoc	.getParagraphs()
											.stream()
											.filter(p -> p.getText().matches("^Prasun-Texte von [0-9]{4}$"))
											.filter(p -> p.getText().matches("^/s*$"))
											.collect(Collectors.toList());
			main.forEach(p -> System.out.println(p.getParagraphText()));

			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
