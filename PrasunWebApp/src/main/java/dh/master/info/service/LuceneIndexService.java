//package dh.master.info.service;
//
//import java.io.File;
//import java.io.IOException;
//
//import org.apache.lucene.analysis.Analyzer;
//import org.apache.lucene.analysis.standard.StandardAnalyzer;
//import org.apache.lucene.document.Document;
//import org.apache.lucene.document.Field;
//import org.apache.lucene.document.TextField;
//import org.apache.lucene.index.IndexWriter;
//import org.apache.lucene.index.IndexWriterConfig;
//import org.apache.lucene.store.Directory;
//import org.apache.lucene.store.SimpleFSDirectory;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Element;
//import org.springframework.stereotype.Service;
//
//import dh.master.info.data.Nuristani;
//
//@Service
//public class LuceneIndexService {
//
//	private org.jsoup.nodes.Document jSoupDoc;
//	private IndexWriter writer;
//
//	public LuceneIndexService(String indexDir) throws IOException {
//		Directory luceneDir = new SimpleFSDirectory(new File(indexDir).toPath());
//		Analyzer analyzer = new StandardAnalyzer();
//		IndexWriterConfig conf = new IndexWriterConfig(analyzer);
//		writer = new IndexWriter(luceneDir, conf);
//		writer.commit();
//
//	}
//
//	public void index(File file, Nuristani result) throws IOException {
//		jSoupDoc = Jsoup.parse(new File("src/main/resources/static/xml/NuristaniDegener.xml"), "UTF-8");
//
//		Document document = new Document();
//
//		for (Element head : jSoupDoc.select("p[rend='prn_head']")) {
//
//			Element next = head.nextElementSibling();
//			if (next != null && next.is("list[type='orderd']")) {
//				String heading = head.text();
//				String content = next.text();
//				document.add(new TextField("heading", heading, Field.Store.YES));
//				document.add(new TextField("content", content, Field.Store.YES));
//			}
//		
//		}
//		writer.addDocument(document);
//		writer.close();
//	}
//
//	public void indexAnnotation(String annotation, Nuristani result) throws IOException {
//		for (Element annotationElement : jSoupDoc.select("p[rend='footnote text']")) {
//			Document doc = new Document();
//			if (annotationElement != null) {
//				annotation = annotationElement.text();
//				doc.add(new TextField("annotation", annotation, Field.Store.YES));
//				result.setAnnotation(annotation);
//			}
//			writer.addDocument(doc);
//		}
//
//	}
//
//	public void close() throws IOException {
//		writer.close();
//	}
//
//	public int getNumDocs() {
//		return writer.numDocs();
//	}
//
//}
