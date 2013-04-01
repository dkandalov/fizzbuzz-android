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
	}

	private static void nSecondsHavePassed(NormalModeGame game, int numberOfSeconds) {
		for (int i = 0; i < numberOfSeconds; i++) {
			game.oneSecondHasPassed();
		}
	}
}
