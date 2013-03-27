package org.fizzbuzzwoof.businesslogic;

/**
 * User: dima
 * Date: 27/03/2013
 */
public class FizzBuzz {
	public enum Type {
		FizzBuzz {
			@Override public String numberToString(int n) {
				if (n % 3 == 0 && n % 5 == 0) return "FizzBuzz";
				else if (n % 3 == 0) return "Fizz";
				else if (n % 5 == 0) return "Buzz";
				else return String.valueOf(n);
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
		};

		public abstract String numberToString(int n);
	}

	public static Type type = Type.FizzBuzz;
}
