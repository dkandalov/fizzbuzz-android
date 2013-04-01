package org.fizzbuzzwoof.businesslogic;

/**
 * Original version borrowed from here http://stackoverflow.com/questions/1720049/print-number-in-words
 */
public class NumberAsWord {
	private static String[] DIGIT_WORDS = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
	private static String[] TENS_WORDS = {"ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
	private static String[] TEENS_WORDS = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

	public static String numberAsWord(int n) {
		if (n > 999 || n < 0)
			throw new IllegalArgumentException("Cannot get hundred word of a number not in the range 0-999");
		if (n == 0) return "zero";

		String result = "";
		if (n > 99) {
			result += DIGIT_WORDS[n / 100] + " hundred ";
			n %= 100;
		}
		if (n < 20 && n > 9) {
			result += TEENS_WORDS[n % 10];
		} else if (n < 10 && n > 0) {
			result += DIGIT_WORDS[n];
		} else if (n != 0) {
			result += TENS_WORDS[n / 10 - 1];
			if (n % 10 != 0) {
				result += " " + DIGIT_WORDS[n % 10];
			}
		}
		return capitalizeFirstLetter(result);
	}

	private static String capitalizeFirstLetter(String s) {
		if (s.isEmpty()) return s;
		return s.replaceFirst(s.substring(0, 1), s.substring(0, 1).toUpperCase());
	}
}
