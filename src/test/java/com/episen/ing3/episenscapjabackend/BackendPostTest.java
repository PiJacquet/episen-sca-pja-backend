package com.episen.ing3.episenscapjabackend;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.episen.ing3.episenscapjabackend.common.StaticData;

@AutoConfigureMockMvc
@SpringBootTest
public class BackendPostTest {
	
    @Autowired
    private MockMvc mvc;

	@Test
	void postValue() throws Exception {
		//Initialize test values
		StaticData.fileName="testFile.txt";
		String example = "valueToBeDetected:" + Math.random()*99999999;
		// Calling the controller
		this.mvc.perform(post("/add/order")
	            .contentType(MediaType.TEXT_PLAIN)
	            .content(example))
	            .andExpect(status().is2xxSuccessful());
		// We then check if the file contains the value previously put
		assertTrue(findValue(example));
	}
	
	private Boolean findValue(String value) {
		File file = new File(StaticData.fileName);
		try {
		    Scanner scanner = new Scanner(file);
		    while (scanner.hasNextLine()) {
		        String line = scanner.nextLine();
		        if(line.contains(value)) {
		        	scanner.close();
		        	return true;
		        }
		    }
		    scanner.close();
		} catch(FileNotFoundException e) {}
		return false;
	}



}
