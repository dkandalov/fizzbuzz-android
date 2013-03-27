package org.fizzbuzzwoof.businesslogic;

/**
 * User: dima
 * Date: 27/03/2013
 */
public class FizzBuzz {
	public enum Type {
		FizzBuzz,
		FizzBuzzWoof
	}

	public static Type type = Type.FizzBuzz;

	public static String fizzBuzz(int counter) {
		if (counter % 3 == 0 && counter % 5 == 0) return "FizzBuzz";
		else if (counter % 3 == 0) return "Fizz";
		else if (counter % 5 == 0) return "Buzz";
		else return String.valueOf(counter);
	}
}
