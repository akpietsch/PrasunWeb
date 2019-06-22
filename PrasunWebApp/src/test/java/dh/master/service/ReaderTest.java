package dh.master.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;

import org.docx4j.jaxb.XPathBinderAssociationIsPartialException;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.wml.Text;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;

import dh.master.info.data.Nuristani;



public class ReaderTest {


		
	
	@Test
	public void readDocx() throws Docx4JException, JAXBException {
		
		File doc = new File("src/main/resources/static/docx/PrasunTexts_5.docx");
		WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage
		  .load(doc);
		MainDocumentPart mainDocumentPart = wordMLPackage
		  .getMainDocumentPart();
		String textNodesXPath = "//w:t";
		List<Object> textNodes= mainDocumentPart
		  .getJAXBNodesViaXPath(textNodesXPath, true);
		for (Object obj : textNodes) {
		    Text text = (Text) ((JAXBElement) obj).getValue();
		    String textValue = text.getValue();
		    System.out.println(textValue);
		}
		
	}
	

}

