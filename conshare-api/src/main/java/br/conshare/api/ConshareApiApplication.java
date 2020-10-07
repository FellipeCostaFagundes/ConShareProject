package br.conshare.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication (scanBasePackages = {"br.conshare.api", "br.conshare.db"})
public class ConshareApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConshareApiApplication.class, args);
	}

}
