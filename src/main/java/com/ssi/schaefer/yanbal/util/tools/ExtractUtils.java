package com.ssi.schaefer.yanbal.util.tools;

public class ExtractUtils {

	public int getJustNumbersFrom(String txt) {
		String digit = "";
		char[] myChars = txt.toCharArray();
		for (char myChar : myChars) {
			if (Character.isDigit(myChar)) {
				digit += myChar;
			}
		}
		return Integer.parseInt(digit);
	}

	public String getJustLettersFrom(String txt) {
		String digit = "";
		char[] myChars = txt.toCharArray();
		for (char myChar : myChars) {
			if (Character.isAlphabetic(myChar)) {
				digit += myChar;
			}
		}
		return digit;
	}

	public String[] getJustSplited(String txt) {
		String[] list = txt.split("-");
		return list;
	}

}
