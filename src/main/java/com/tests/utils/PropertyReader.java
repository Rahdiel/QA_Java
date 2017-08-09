package com.tests.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class PropertyReader {
	static Properties properties = null;

	private static void loadProperties() {
		properties = new Properties();

		try {
			URL inputStreamUrl = ClassLoader.getSystemResource("config.properties");
			properties.load(new FileInputStream(inputStreamUrl.getFile()));

		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	public static void setProperty(String propName, String propValue) {
		if (properties == null)
			loadProperties();
		if (propValue != null)
			properties.setProperty(propName, propValue);
	}

	public static String readProperty(String key) {
		if (properties == null)
			loadProperties();
		return properties.getProperty(key);
	}

	public static void Destroy() {
		properties = null;
	}

}
