package org.fizzbuzzwoof.businesslogic;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class NormalModeGameTest {
	@Test public void amountOfTimeLeftShouldDecreaseAfterEachSecond() {
		NormalModeGame game = new NormalModeGame(FizzBuzz.Type.FizzBuzz);
		assertThat(game.timeLeft(), equalTo("01:00"));
		game.oneSecondHasPassed();
		assertThat(game.timeLeft(), equalTo("00:59"));
		game.oneSecondHasPassed();
		assertThat(game.timeLeft(), equalTo("00:58"));
	}

	@Test public void amountOfTimeLeftCannotBeLessThanZero() {
		NormalModeGame game = new NormalModeGame(FizzBuzz.Type.FizzBuzz);
		nSecondsHavePassed(game, 59);
		assertThat(game.timeLeft(), equalTo("00:01"));
		game.oneSecondHasPassed();
		assertThat(game.timeLeft(), equalTo("00:00"));
		game.oneSecondHasPassed();
		assertThat(game.timeLeft(), equalTo("00:00"));
	}

	private static void nSecondsHavePassed(NormalModeGame game, int numberOfSeconds) {
		for (int i = 0; i < numberOfSeconds; i++) {
			game.oneSecondHasPassed();
		}
	}
}
