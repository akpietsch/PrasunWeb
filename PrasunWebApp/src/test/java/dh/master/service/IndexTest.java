package dh.master.service;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import dh.master.info.data.NuristaniDAO;
import dh.master.info.service.IndexService;

public class IndexTest {

	private Document doc;
	private NuristaniDAO result;

	@Test
	public void test() throws IOException {
		File input = new File("src/main/resources/static/xml/NuristaniDegener.xml");
		doc = Jsoup.parse(input, "UTF-8");

//		Elements headings = doc.select("p[rend='prn_head']");
//
//		System.out.println("Das sind die Überschriften:");
//		System.out.println(headings.eachText());

	}
//
//	@Test
//	public void readContent() throws IOException {
//		File input = new File("src/main/resources/static/xml/NuristaniDegener.xml");
//		doc = Jsoup.parse(input, "UTF-8");
//
//		Elements content = doc.select("item");
//		// list[type='ordered'],[lang='prn']
//		System.out.println("Das sind die Texte:");
//		System.out.println(content.eachText());
//
//	}
//
//	@Test
//	public void readNotes() throws IOException {
//		File input = new File("src/main/resources/static/xml/NuristaniDegener.xml");
//		doc = Jsoup.parse(input, "UTF-8");
//
//		Elements notes = doc.select("p[rend='footnote text']");
//		System.out.println("Das sind die Fußnoten:");
//		System.out.println(notes.eachText());
//	}

}
