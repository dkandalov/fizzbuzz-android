package org.fizzbuzzwoof.businesslogic;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class NormalModeGameTest {
	private final FizzBuzz.Type fizzBuzzType = FizzBuzz.Type.FizzBuzz;
	private final NormalModeGame game = new NormalModeGame(fizzBuzzType);

	@Test public void amountOfTimeLeftShouldDecreaseAfterEachSecond() {
		assertThat(game.timeLeft(), equalTo("01:00"));
		game.oneSecondHasPassed(); assertThat(game.timeLeft(), equalTo("00:59"));
		game.oneSecondHasPassed(); assertThat(game.timeLeft(), equalTo("00:58"));
	}

	@Test public void amountOfTimeLeftCannotBeLessThanZero() {
		nSecondsHavePassed(game, 59); assertThat(game.timeLeft(), equalTo("00:01"));
		game.oneSecondHasPassed(); assertThat(game.timeLeft(), equalTo("00:00"));
		game.oneSecondHasPassed(); assertThat(game.timeLeft(), equalTo("00:00"));
	}

	@Test public void whenUserMovesAreCorrect_ScoreShouldIncrease() {
		NormalModeGame.Score score = new NormalModeGame.Score();
		assertThat(score.asString(), equalTo("0"));

		score.userWasRight(); assertThat(score.asString(), equalTo("1"));
		score.userWasRight(); assertThat(score.asString(), equalTo("2"));
	}

	@Test public void whenUserMovesAreCorrectLongEnough_ScoreShouldIncreaseFaster() {
		NormalModeGame.Score score = new NormalModeGame.Score();
		assertThat(score.asString(), equalTo("0"));

		userWasRightNTimes(score, 10); assertThat(score.asString(), equalTo("10"));
		score.userWasRight(); assertThat(score.asString(), equalTo("12"));
		userWasRightNTimes(score, 8); assertThat(score.asString(), equalTo("28"));
		score.userWasRight(); assertThat(score.asString(), equalTo("31"));
	}

	@Test public void whenUserMovesAreWrongLongEnough_ScoreShouldDecrease() {
		NormalModeGame.Score score = new NormalModeGame.Score();
		assertThat(score.asString(), equalTo("0"));

		score.userWasRight(); assertThat(score.asString(), equalTo("1"));
		score.userWasWrong(); assertThat(score.asString(), equalTo("1"));
		score.userWasWrong(); assertThat(score.asString(), equalTo("1"));
		score.userWasWrong(); assertThat(score.asString(), equalTo("0"));
	}

	private static void userWasRightNTimes(NormalModeGame.Score score, int n) {
		for (int i = 0; i < n; i++) {
			score.userWasRight();
		}
	}

	private static void nSecondsHavePassed(NormalModeGame game, int numberOfSeconds) {
		for (int i = 0; i < numberOfSeconds; i++) {
			game.oneSecondHasPassed();
		}
	}
}
