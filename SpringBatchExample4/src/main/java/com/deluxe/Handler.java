package com.deluxe;

import java.io.File;

/**
 * A class providing several handling methods for different types of payloads.
 * 
 * @author Mark Fisher
 * @author Marius Bogoevici
 */
public class Handler {

	public String handleString(String input) {
		System.out.println("Copying text: " + input);
		return input.toUpperCase();
	}
	
	public File handleFile(File input) {
		System.out.println("Copying file: " + input.getAbsolutePath());
		return input;
	}
	
	public byte[] handleBytes(byte[] input) {
		System.out.println("Copying " + input.length + " bytes ...");
		return new String(input).toUpperCase().getBytes();
	}

}