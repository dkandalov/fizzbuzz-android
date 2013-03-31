package org.fizzbuzzwoof.businesslogic;

import java.util.List;

import static java.util.Arrays.asList;

public class FizzBuzz {
	public enum Type {
		FizzBuzz {
			@Override public String numberToString(int n) {
				if (n % 3 == 0 && n % 5 == 0) return "FizzBuzz";
				else if (n % 3 == 0) return "Fizz";
				else if (n % 5 == 0) return "Buzz";
				else return String.valueOf(n);
			}

			@Override public List<String> allChoices(int n) {
				return asList(String.valueOf(n), "Fizz", "Buzz", "FizzBuzz");
			}
		},
		FizzBuzzWoof {
			@Override public String numberToString(int n) {
				if (n % 3 == 0 && n % 5 == 0 && n % 7 == 0) return "FizzBuzzWoof";
				else if (n % 3 == 0 && n % 5 == 0) return "FizzBuzz";
				else if (n % 3 == 0 && n % 7 == 0) return "FizzWoof";
				else if (n % 5 == 0 && n % 7 == 0) return "BuzzWoof";
				else if (n % 3 == 0) return "Fizz";
				else if (n % 5 == 0) return "Buzz";
				else if (n % 7 == 0) return "Woof";
				else return String.valueOf(n);
			}

			@Override public List<String> allChoices(int n) {
				return null; // TODO
			}
		};

		public abstract String numberToString(int n);
		public abstract List<String> allChoices(int n);
	}

	public static Type type = Type.FizzBuzz;
}
