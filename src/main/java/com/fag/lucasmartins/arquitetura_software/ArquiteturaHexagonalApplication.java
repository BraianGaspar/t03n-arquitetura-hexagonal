package com.fag.lucasmartins.arquitetura_software;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class ArquiteturaHexagonalApplication {

	private static final Logger log = LoggerFactory.getLogger(ArquiteturaHexagonalApplication.class);

	public static void main(String[] args) {
		try {
			Dotenv dotenv = Dotenv.configure()
				.directory("./")
				.ignoreIfMissing()
				.load();
			
			dotenv.entries().forEach(entry -> {
				String key = entry.getKey();
				String value = entry.getValue();
				System.setProperty(key, value);
			});
						
		} catch (Exception e) {
			log.warn("Erro: {}", e.getMessage());
		}
		
		SpringApplication.run(ArquiteturaHexagonalApplication.class, args);
	}

}
