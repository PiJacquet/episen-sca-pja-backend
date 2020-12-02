package com.episen.ing3.episenscapjabackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class EpisenScaPjaBackendApplication {

	public static void main(String[] args) {
		log.info("Launching the application");
		SpringApplication.run(EpisenScaPjaBackendApplication.class, args);
	}

}
