package org.fizzbuzzwoof.activities;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import org.fizzbuzzwoof.R;
import org.fizzbuzzwoof.businesslogic.FizzBuzz;

public class ZenMode extends Activity {
	private static int INITIAL_VALUE = 1;
	private int counter = INITIAL_VALUE;

	@Override public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.zen_mode);

		counter = loadFromConfig();
		TextView fizzBuzzText = (TextView) findViewById(R.id.zenModeFizzBuzzText);
		fizzBuzzText.setText(FizzBuzz.type.numberToFizzBuzzString(counter));
	}

	@Override protected void onPause() {
		super.onPause();
		saveToConfig(counter);
	}

	@Override public void onBackPressed() {
		counter = INITIAL_VALUE;
		super.onBackPressed();
	}

	private void saveToConfig(int counter) {
		SharedPreferences.Editor preferences = getSharedPreferences(getString(R.string.config_file_key), Context.MODE_PRIVATE).edit();
		preferences.putInt(getString(R.string.config_zen_mode_counter), counter);
		preferences.commit();
	}

	private int loadFromConfig() {
		SharedPreferences preferences = getSharedPreferences(getString(R.string.config_file_key), Context.MODE_PRIVATE);
		return preferences.getInt(getString(R.string.config_zen_mode_counter), INITIAL_VALUE);
	}

	public void fizzBuzzCount(View view) {
		TextView fizzBuzzText = (TextView) findViewById(R.id.zenModeFizzBuzzText);
		fizzBuzzText.setText(FizzBuzz.type.numberToFizzBuzzString(++counter));
	}
}
