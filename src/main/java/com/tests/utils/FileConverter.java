package com.tests.utils;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileConverter {
	private static final Logger log = LoggerFactory.getLogger(FileConverter.class);

	public static byte[] toBinary(String file) throws IOException {
		log.info("Converting started.");

		// file=Converter.convertULRforOS(file);

		URL url = ClassLoader.getSystemResource(file);

		log.info("URL is: " + url.toString());

		File f = null;
		try {
			f = new File(url.toURI());
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		byte[] data = Files.readAllBytes(f.toPath());
		log.info("Converting is complete.");
		return data;
	}

	public static String toMultiPart(String file) throws IOException {
		log.info("Converting started.");
		
		log.info("Converting is complete.");
		return file;

	}
}
