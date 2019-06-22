package dh.master.info;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dh.master.info.service.IndexService;

@SpringBootApplication
public class PrasunWebAppApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(PrasunWebAppApplication.class, args);
		IndexService indexer = new IndexService();
		indexer.parseDoc("src/main/resources/static/xml/NuristaniDegener.xml");
	}

}

