package com.tests.utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Converter {
	private static final Logger log = LoggerFactory.getLogger(Converter.class);

	public enum Option {
		noWhiteSpace, noNewLine, noWhitespacesOnBeginAndEnd, onlyLetters
	}

	// convert price to double from price string
	public static double convertPrice(String price_string) {
		double price = 0.00;

		NumberFormat format = NumberFormat.getInstance(Locale.UK);

		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < price_string.length(); i++) {
			char c = price_string.charAt(i);
			if ((c > 47 && c < 58) || c == 46 || c == 44) {
				builder.append(c);
			}
		}
		price_string = builder.toString();
		return price = getPriceParseDouble(price, price_string, format);
	}
	
	public static double convertPriceFromFront(String price_string) {
		double price = 0.00;

		String country = PropertyReader.readProperty("country");
		NumberFormat format = NumberFormat.getInstance(Locale.getDefault());

		if (country.equals("UK")) {
			format = NumberFormat.getInstance(Locale.UK);
		} else if (country.equals("DE")) {
			format = NumberFormat.getInstance(Locale.GERMANY);
		} else if (country.equals("FR")) 
		{
			format = NumberFormat.getInstance(Locale.FRANCE);
		} else if (country.equals("ES")) {
			format = NumberFormat.getInstance(Locale.FRANCE);
		} else if (country.equals("IT")) {
			format = NumberFormat.getInstance(Locale.ITALY);
		}
			else {
			format = NumberFormat.getInstance(Locale.UK);
		}

		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < price_string.length(); i++) {
			char c = price_string.charAt(i);
			if ((c > 47 && c < 58) || c == 46 || c == 44) {
				builder.append(c);
			}
		}
		price_string = builder.toString();
		return price = getPriceParseDouble(price, price_string, format);
	}

	// parse price string to double
	private static double getPriceParseDouble(double price, String price_string, NumberFormat format) {
		try {
			//price = (double) format.parse(price_string);
			Number number = format.parse(price_string);
			price = number.doubleValue();
			price = Double.parseDouble(new DecimalFormat("##.##").format(price));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return price;
		
	}
	
	public static String getURLString(String text){
		String result="";
		result=text.toLowerCase().replaceAll(" ","-");
		result=result.replaceAll("'", "%27");
		result=result.replaceAll("é", "%c3%a9");
		return result;
	}

	// get double from string
	public static double getDouble(String value_string) {
		double value = 0.00;

		NumberFormat format = NumberFormat.getInstance(Locale.getDefault());
		StringBuilder builder = new StringBuilder();
		DecimalFormatSymbols decimalFormat = new DecimalFormatSymbols(Locale.UK);

		for (int i = 0; i < value_string.length(); i++) {
			char c = value_string.charAt(i);
			if ((c > 47 && c < 58) || c == 46 || c == 44) {
				builder.append(c);
			}
		}

		value_string = builder.toString();

		try {
			Number number = format.parse(value_string);
			value = number.doubleValue();
			value = Double.parseDouble(new DecimalFormat("##.##", decimalFormat).format(value));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return value;
	}

	// get double from multiply
	public static double getDoubleFromMultiply(double value) {
		double result = 0.00;

		DecimalFormatSymbols format = new DecimalFormatSymbols(Locale.UK);
		result = Double.parseDouble(new DecimalFormat("##.##", format).format(value));

		return result;
	}

	// get text from string with option type
	public static String getText(String text, Option type) {
		String result = "";

		if (type.equals(Option.noWhiteSpace)) {
			String pattern = "\\s";
			Pattern r = Pattern.compile(pattern);
			Matcher m = r.matcher(text);
			result = m.replaceAll("");
		}
		if (type.equals(Option.noNewLine)) {
			String pattern = "\\n";
			Pattern r = Pattern.compile(pattern);
			Matcher m = r.matcher(text);
			result = m.replaceAll("");
		}
		if (type.equals(Option.noWhitespacesOnBeginAndEnd)){
			String pattern = "^\\s+|\\s+$";
			Pattern r = Pattern.compile(pattern);
			Matcher m = r.matcher(text);
			result = m.replaceAll("");
		}
		if (type.equals(Option.onlyLetters)){
			String pattern = "~[a-zA-Z]+";
			Pattern r = Pattern.compile(pattern);
			Matcher m = r.matcher(text);
			result = m.replaceAll("");
		}
		return result;
	}

	public static List<String> getText(List<String> textList, Option type) {
		List<String> textResultList = new ArrayList<String>();
		
		for (String text: textList){
			textResultList.add(Converter.getText(text, type));
		}
		
		return textResultList;
	}
	
	public static String convertULRforOS(String text){
		if(PropertyReader.readProperty("os").equals("")){
			String osName = System.getProperty("os.name").toLowerCase();
			log.info("This is system os: "+osName);
			PropertyReader.setProperty("os", osName);
			if(PropertyReader.readProperty("os").contains("windwos")){
				return text.replace("/", "\\\\");
			}else{
				return text;
			}
		}else{
			if(PropertyReader.readProperty("os").contains("windwos")){
				return text.replace("/", "\\\\");
			}else{
				return text;
			}
			
		}
		
	}

}
