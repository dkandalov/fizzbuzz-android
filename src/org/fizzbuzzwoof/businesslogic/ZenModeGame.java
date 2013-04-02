package org.fizzbuzzwoof.businesslogic;

public class ZenModeGame {
	public static int INITIAL_VALUE = 1;

	private final FizzBuzz.Type fizzBuzz;
	private int counter = INITIAL_VALUE;

	public ZenModeGame(FizzBuzz.Type fizzBuzz) {
		this.fizzBuzz = fizzBuzz;
	}

	public String nextNumber() {
		return fizzBuzz.numberToFizzBuzzString(++counter);
	}

	public String getCurrentNumber() {
		return fizzBuzz.numberToFizzBuzzString(counter);
	}

	public boolean isFizzBuzz() {
		int i = fizzBuzz.allChoices(counter).indexOf(getCurrentNumber());
		return i > 0;
	}

	public void resetState() {
		counter = INITIAL_VALUE;
	}

	public int getState() {
		return counter;
	}

	public void setState(int value) {
		counter = value;
	}
}
