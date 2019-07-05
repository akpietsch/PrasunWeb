package dh.master.info;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
@SpringBootApplication
public class PrasunWebAppApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(PrasunWebAppApplication.class, args);
	}

}
