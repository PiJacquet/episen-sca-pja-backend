package com.episen.ing3.episenscapjabackend.common;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StaticData {

	public static String fileName = "/usr/local/orders.txt";
	
	public static void writeInFile(String text) {
		writeInFile(text,fileName);
	}

	public static void writeInFile(String text, String file) {
		text+=System.lineSeparator();
		try {
			try {
				Files.write(Paths.get(fileName), text.getBytes(), StandardOpenOption.APPEND);
				log.info("The text as added to the file");
			}
			catch(NoSuchFileException nf) {
				nf.printStackTrace();
				log.info("The text file didn't exist and will be created");
				FileWriter fw = new FileWriter(fileName);
				fw.write(text);
				log.info("The text was added to the file");
				fw.close();
			}
		}catch(IOException io) {
			log.error("An error occured during the writing process " + io.getMessage());
			io.printStackTrace();
		}
	}

}
