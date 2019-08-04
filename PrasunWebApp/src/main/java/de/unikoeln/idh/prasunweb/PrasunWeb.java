package de.unikoeln.idh.prasunweb;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
@SpringBootApplication
public class PrasunWeb {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(PrasunWeb.class, args);
	}

}
