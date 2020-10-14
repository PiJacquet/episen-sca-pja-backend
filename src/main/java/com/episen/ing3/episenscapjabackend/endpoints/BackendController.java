package com.episen.ing3.episenscapjabackend.endpoints;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.episen.ing3.episenscapjabackend.common.StaticData;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BackendController {
	
	@PostMapping("/add/order")
	@SuppressWarnings("rawtypes")
	/* Ajout d'une valeur */
	public ResponseEntity addValue(@RequestBody String value) {
		log.info("adding Value " + value);
		StaticData.writeInFile(value);
		return ResponseEntity.ok().build();
	}

}
