package org.fizzbuzzwoof.businesslogic;

import java.util.List;

public class NormalModeGame {
	private static int INITIAL_VALUE = 1;

	private final FizzBuzz.Type fizzBuzz;
	private int counter = INITIAL_VALUE;
	private int secondsLeft = 60;

	public NormalModeGame(FizzBuzz.Type fizzBuzz) {
		this.fizzBuzz = fizzBuzz;
	}

	public boolean userMadeMove(String answer) {
		if (!fizzBuzz.isCorrectAnswer(answer, counter)) return false;
		counter++;
		return true;
	}

	public List<String> allPossibleMoves() {
		return fizzBuzz.allChoices(counter);
	}

	public void oneSecondHasPassed() {
		if (secondsLeft > 0) secondsLeft--;
	}

	public String timeLeft() {
		if (secondsLeft == 60) return "01:00";
		else return "00:" + String.format("%02d", secondsLeft);
	}
}
