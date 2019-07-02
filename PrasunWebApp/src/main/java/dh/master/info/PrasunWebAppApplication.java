package dh.master.info;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableJpaRepositories("dh.master.info.repository")
@EntityScan
public class PrasunWebAppApplication{

	public static void main(String[] args) throws IOException {
		SpringApplication.run(PrasunWebAppApplication.class, args);

	}

}
