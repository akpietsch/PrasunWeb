package dh.master.info.service;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import dh.master.info.data.Nuristani;

@Service
public class IndexService {

	private Document doc;

	public Nuristani parseDoc(String path) throws IOException {
		doc = Jsoup.parse(new File(path), "UTF-8");
		Nuristani result = new Nuristani();

		for (Element head : doc.select("p[rend=prn_head]")) {
			Element next = head.nextElementSibling();

			if (next != null && next.is("list[type=orderd]")) {
				String heading = head.text();
				String content = next.text();

				result.setHeading(heading);
				result.setText(content);

			}
		}
		return result;
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
