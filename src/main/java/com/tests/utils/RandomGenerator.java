package com.tests.utils;

import java.util.Random;

import com.tests.utils.Converter.Option;

public class RandomGenerator {

	public enum InputType {
		capital_letters, small_letters, numbers, long_description, short_description, identifier, name, strapline, codeFiscale, url
	}

	public static int getRandomInt(int min, int max) {
		int randomInt = 0;

		randomInt = min + (int) Math.round(Math.random() * (max - min));

		return randomInt;

	}

	public static String generateSomeName(int firstNameLang) {
		return RandomGenerator.getRandomInput(RandomGenerator.InputType.capital_letters, 1)
				+ RandomGenerator.getRandomInput(RandomGenerator.InputType.small_letters,
						RandomGenerator.getRandomInt(1, firstNameLang - 1));
	}

	public static String generateSomeEmail() {
		return "success+" + RandomGenerator.getRandomInput(RandomGenerator.InputType.small_letters, 10)
				+ RandomGenerator.getRandomInput(RandomGenerator.InputType.numbers, 10) + "@simulator.amazonses.com";
	}

	public static String generateSomePhoneNumber(String areaCode, int phoneLang) {
		return areaCode + RandomGenerator.getRandomInput(InputType.numbers, phoneLang);

	}

	public static String getRandomInput(InputType inputType, int lenght) {

		String resultOfRandom = "";
		char[] chars = "".toCharArray();

		if (inputType.equals(InputType.capital_letters)) {
			chars = "QWERTYUIOPASDFGHJKLZXCVBNM".toCharArray();

		}
		if (inputType.equals(InputType.small_letters)) {
			chars = "qwertyuiopasdfghjklzxcvbnm".toCharArray();

		}
		if (inputType.equals(InputType.numbers)) {
			chars = "123456789".toCharArray();

		}
		if (inputType.equals(InputType.long_description)) {
			chars = "123456789QWERTYUIOPLKJHGFDSAZXCVBNMqwertyuioplkjhgfdsazxcvbnm ,.?!%\n".toCharArray();

		}
		if (inputType.equals(InputType.short_description)) {
			chars = "123456789QWERTYUIOPLKJHGFDSAZXCVBNMqwertyuioplkjhgfdsazxcvbnm ,.?!%".toCharArray();

		}
		if (inputType.equals(InputType.identifier)) {
			chars = "123456789QWERTYUIOPLKJHGFDSAZXCVBNM ,".toCharArray();

		}
		if (inputType.equals(InputType.name)) {
			chars = "123456789QWERTYUIOPLKJHGFDSAZXCVBNM ".toCharArray();

		}
		if (inputType.equals(InputType.strapline)) {
			chars = "1234567890QWERTYUIOPLKJHGFDSAZXCVBNMqwertyuiopasdfghjklzxcvbnm".toCharArray();

		}
		if (inputType.equals(InputType.codeFiscale)) {
			chars = "1234567890QWERTYUIOPLKJHGFDSAZXCVBNM".toCharArray();

		}
		if (inputType.equals(InputType.url)) {
			chars = "1234567890qwertyuioplkjhgfdsazxcvbnm.".toCharArray();

		}

		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < lenght; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		resultOfRandom = sb.toString();

		resultOfRandom = Converter.getText(resultOfRandom, Option.noWhitespacesOnBeginAndEnd);

		return resultOfRandom;
	}

	public static boolean getRandomBoolean() {
		Random random = new Random();
		return random.nextBoolean();
	}

}
