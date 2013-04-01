package org.fizzbuzzwoof.businesslogic;

import java.util.List;

import static java.lang.String.valueOf;

public class NormalModeGame {
	private static int INITIAL_VALUE = 1;

	private final FizzBuzz.Type fizzBuzz;
	private int counter = INITIAL_VALUE;
	private int secondsLeft = 60;
	private final Score score = new Score();

	public NormalModeGame(FizzBuzz.Type fizzBuzz) {
		this.fizzBuzz = fizzBuzz;
	}

	public boolean userMadeMove(String answer) {
		if (!fizzBuzz.isCorrectAnswer(answer, counter)) {
			score.userWasWrong();
			return false;
		} else {
			score.userWasRight();
			counter++;
			return true;
		}
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

	public String score() {
		return score.asString();
	}

	static class Score {
		private int value = 0;
		private int rightAnswersInARow = 0;
		private int wrongAnswersInARow = 0;

		public void userWasRight() {
			rightAnswersInARow++;
			wrongAnswersInARow = 0;
			if (rightAnswersInARow > 10) {
				value += (rightAnswersInARow / 10);
			}
			value++;
		}

		public void userWasWrong() {
			rightAnswersInARow = 0;
			wrongAnswersInARow++;
			if (wrongAnswersInARow > 2) value--;
		}

		public String asString() {
			return valueOf(value);
		}
	}
}
