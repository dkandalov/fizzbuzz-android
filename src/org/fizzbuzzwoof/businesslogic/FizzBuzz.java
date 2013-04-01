package org.fizzbuzzwoof.businesslogic;

import java.util.List;

import static java.util.Arrays.asList;
import static org.fizzbuzzwoof.businesslogic.NumberAsWord.numberAsWord;

public class FizzBuzz {
	public enum Type {
		FizzBuzz {
			@Override public String numberToFizzBuzzString(int n) {
				if (n % 3 == 0 && n % 5 == 0) return "FizzBuzz";
				else if (n % 3 == 0) return "Fizz";
				else if (n % 5 == 0) return "Buzz";
				else return numberAsWord(n);
			}

			@Override public List<String> allChoices(int n) {
				return asList(numberAsWord(n), "Fizz", "Buzz", "FizzBuzz");
			}
		},
		FizzBuzzWoof {
			@Override public String numberToFizzBuzzString(int n) {
				if (n % 3 == 0 && n % 5 == 0 && n % 7 == 0) return "FizzBuzzWoof";
				else if (n % 3 == 0 && n % 5 == 0) return "FizzBuzz";
				else if (n % 3 == 0 && n % 7 == 0) return "FizzWoof";
				else if (n % 5 == 0 && n % 7 == 0) return "BuzzWoof";
				else if (n % 3 == 0) return "Fizz";
				else if (n % 5 == 0) return "Buzz";
				else if (n % 7 == 0) return "Woof";
				else return numberAsWord(n);
			}

			@Override public List<String> allChoices(int n) {
				return asList(numberAsWord(n), "Fizz", "Buzz", "Woof", "FizzBuzz", "FizzWoof", "BuzzWoof", "FizzBuzzWoof");
			}
		};

		public abstract String numberToFizzBuzzString(int n);
		public abstract List<String> allChoices(int n);

		public boolean isCorrectAnswer(String answer, int n) {
			return numberToFizzBuzzString(n).equals(answer);
		}
	}

	public static Type type = Type.FizzBuzz;
}
