package de.unikoeln.idh.prasunweb.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)

@Component
@ConfigurationProperties(prefix = "file")
public class Importer {

	
	private String importDir;

}
