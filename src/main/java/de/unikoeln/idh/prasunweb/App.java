package de.unikoeln.idh.prasunweb;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;

import de.unikoeln.idh.prasunweb.lucene.LuceneIndexConfig;
@EntityScan({"de.unikoeln.idh.prasunweb.model"})
@SpringBootApplication
@Import(LuceneIndexConfig.class)
public class App {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(App.class, args);
    }

}
