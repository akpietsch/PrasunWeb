package dh.master.service;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import dh.master.info.data.Nuristani;

public class IndexTest {

	private Document doc;

	
	public void readHeadings() throws IOException {
		File input = new File("src/main/resources/static/xml/NuristaniDegener.xml");
		doc = Jsoup.parse(input, "UTF-8");

		Elements headings = doc.select("p[rend='prn_head']");

		System.out.println("Das sind die Überschriften:");
		System.out.println(headings.eachText());

	}


	public void readContent() throws IOException {
		File input = new File("src/main/resources/static/xml/NuristaniDegener.xml");
		doc = Jsoup.parse(input, "UTF-8");

		Elements content = doc.select("item");
		// list[type='ordered'],[lang='prn']
		System.out.println("Das sind die Texte:");
		System.out.println(content.eachText());

	}

	public void readNotes() throws IOException {
		File input = new File("src/main/resources/static/xml/NuristaniDegener.xml");
		doc = Jsoup.parse(input, "UTF-8");

		Elements notes = doc.select("p[rend='footnote text']");
		System.out.println("Das sind die Fußnoten:");
		System.out.println(notes.eachText());
	}

	@Test
	public void parseDoc() throws IOException {

		doc = Jsoup.parse(new File("src/main/resources/static/xml/NuristaniDegener.xml"), "UTF-8");

		for (Element head : doc.select("p[rend='prn_head']")) {

			Element next = head.nextElementSibling();
			if (next != null && next.is("list[type='orderd']")) {
				String heading = head.text();
				String content = next.text();

		
				System.out.println(head.text());
			
				System.out.println(next.text());

			}

		}
	}
}
