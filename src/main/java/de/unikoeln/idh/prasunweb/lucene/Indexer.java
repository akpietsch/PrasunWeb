package de.unikoeln.idh.prasunweb.lucene;
//package de.unikoeln.idh.prasunweb.lucene;
//
//import java.awt.TextField;
//import java.io.File;
//import java.io.IOException;
//
//import org.apache.lucene.analysis.Analyzer;
//import org.apache.lucene.analysis.standard.StandardAnalyzer;
//import org.apache.lucene.document.Document;
//import org.apache.lucene.index.IndexWriter;
//import org.apache.lucene.index.IndexWriterConfig;
//import org.apache.lucene.index.IndexableField;
//import org.apache.lucene.store.Directory;
//import org.apache.lucene.store.SimpleFSDirectory;
//
//import de.unikoeln.idh.prasunweb.model.Book;
//
//public class Indexer {
//
//    private IndexWriter writer;
//
//    public Indexer(String indexDir) throws IOException {
//        Directory luceneDir = new SimpleFSDirectory(new File(indexDir).toPath());
//        Analyzer analyzer = new StandardAnalyzer();
//        IndexWriterConfig conf = new IndexWriterConfig(analyzer);
//        writer = new IndexWriter(luceneDir, conf);
//    }
//
//    private Document buildLuceneDocument() {
//        Document doc = new Document();
//        Book book;
//        doc.add((IndexableField) new TextField(""));
//
//        return doc;
//
//    }
//
//    public void close() throws IOException {
//        writer.close();
//    }
//
//}
