package dh.master.info.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.springframework.stereotype.Service;

import dh.master.info.data.Nuristani;

@Service
public class IndexService {
	/**
	 * 
	 */
	private Document doc;

	public List<Nuristani> parseDoc(String path) throws IOException {
        InputStream is = new FileInputStream(new File(path));
        Document doc = Jsoup.parse(is, "UTF-8", "", Parser.xmlParser());
        ArrayList<Nuristani> results = new ArrayList<Nuristani>();

        for (Element head : doc.select("p[rend='prn_head']")) {
                Element text = head.nextElementSibling();

                if (text != null && text.is("list[type='ordered']")) {
                        Nuristani result = new Nuristani();
                        result.setHeading(head.text());
                        result.setText(text.text());
                        results.add(result);
                }
        }

        return results;
}


	public Nuristani parseAnnotation(String annotation, Nuristani result) {
		for (Element annotationElement : doc.select("p[rend='footnote text']")) {
			if (annotationElement != null) {
				annotation = annotationElement.text();
				result.setAnnotation(annotation);
			}

		}
		return result;
	}
	
	
	
	
	

}
