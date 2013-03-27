package org.fizzbuzzwoof.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import org.fizzbuzzwoof.R;
import org.fizzbuzzwoof.businesslogic.FizzBuzz;

public class Home extends Activity {
	@Override public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
	}

	@Override protected void onStart() {
		super.onStart();
		FizzBuzz.type = loadFromConfig(FizzBuzz.type);
	}

	private FizzBuzz.Type loadFromConfig(FizzBuzz.Type defaultValue) {
		SharedPreferences preferences = getSharedPreferences(getString(R.string.config_file_key), Context.MODE_PRIVATE);
		String value = preferences.getString(getString(R.string.config_fizzBuzzType), null);
		return value == null ? defaultValue : FizzBuzz.Type.valueOf(value);
	}

	public void userWantsToOpenZenMode(View view) {
		startActivity(new Intent(this, ZenMode.class));
	}

	public void userWantsToOpenSettings(View view) {
		startActivity(new Intent(this, Settings.class));
	}

	public void userWantsToExit(View view) {
		finish();
	}
}