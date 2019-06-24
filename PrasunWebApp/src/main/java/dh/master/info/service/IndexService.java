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

import dh.master.info.model.Work;

@Service
public class IndexService {
	
	String path= "src/main/resources/static/xml/NuristaniDegener.xml";
	Document doc;

	public List<Work> parseDoc(String path) throws IOException {
        InputStream is = new FileInputStream(new File(path));
        Document doc = Jsoup.parse(is, "UTF-8", "", Parser.xmlParser());
        ArrayList<Work> results = new ArrayList<Work>();

        for (Element head : doc.select("p[rend='prn_head']")) {
                Element text = head.nextElementSibling();

                if (text != null && text.is("list[type='ordered']")) {
                        Work result = new Work();
                        result.setHeading(head.text());
                        result.setText(text.text());
                        results.add(result);
                }
        }

        return results;
}


	public Work parseAnnotation(String annotation, Work result) {
		for (Element annotationElement : doc.select("p[rend='footnote text']")) {
			if (annotationElement != null) {
				annotation = annotationElement.text();
				result.setAnnotation(annotation);
			}

		}
		return result;
	}
	
	
	
	
	

}
