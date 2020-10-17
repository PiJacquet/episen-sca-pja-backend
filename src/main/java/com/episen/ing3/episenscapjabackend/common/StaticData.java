package com.episen.ing3.episenscapjabackend.common;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

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
			}
			catch(NoSuchFileException nf) {
				nf.printStackTrace();
				FileWriter fw = new FileWriter(fileName);
				fw.write(text);
				fw.close();
			}
		}catch(IOException io) {
			io.printStackTrace();
		}
	}

}
