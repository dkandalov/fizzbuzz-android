package org.fizzbuzzwoof.activities;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import org.fizzbuzzwoof.R;
import org.fizzbuzzwoof.businesslogic.FizzBuzz;
import org.fizzbuzzwoof.businesslogic.ZenModeGame;

public class ZenMode extends Activity {
	private final ZenModeGame game = new ZenModeGame(FizzBuzz.type);

	@Override public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.zen_mode);

		game.setState(loadFromConfig());
		updateUI(game.getCurrentNumber());
	}

	@Override protected void onPause() {
		super.onPause();
		saveToConfig(game.getState());
	}

	@Override public void onBackPressed() {
		game.resetState();
		super.onBackPressed();
	}

	@SuppressWarnings("UnusedParameters")
	public void fizzBuzzClicked(View view) {
		updateUI(game.nextNumber());
	}

	private void updateUI(String text) {
		((TextView) findViewById(R.id.zenModeFizzBuzzText)).setText(text);
	}

	private void saveToConfig(int counter) {
		SharedPreferences.Editor preferences = getSharedPreferences(getString(R.string.config_file_key), Context.MODE_PRIVATE).edit();
		preferences.putInt(getString(R.string.config_zen_mode_counter), counter);
		preferences.commit();
	}

	private int loadFromConfig() {
		SharedPreferences preferences = getSharedPreferences(getString(R.string.config_file_key), Context.MODE_PRIVATE);
		return preferences.getInt(getString(R.string.config_zen_mode_counter), ZenModeGame.INITIAL_VALUE);
	}
}
