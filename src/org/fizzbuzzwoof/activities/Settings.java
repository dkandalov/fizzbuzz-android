package org.fizzbuzzwoof.activities;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import org.fizzbuzzwoof.R;
import org.fizzbuzzwoof.businesslogic.FizzBuzz;

public class Settings extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings);

		RadioGroup radioGroup = (RadioGroup) findViewById(R.id.fizzBuzzTypeRadioGroup);
		radioGroup.check(convertToId(FizzBuzz.type));
	}

	public void userSelectedFizzBuzzType(View view) {
		RadioGroup radioGroup = (RadioGroup) findViewById(R.id.fizzBuzzTypeRadioGroup);
		FizzBuzz.type = convertToType(radioGroup.getCheckedRadioButtonId());
		finish();
	}

	@Override protected void onPause() {
		super.onPause();
		saveToConfig(FizzBuzz.type);
	}

	private void saveToConfig(FizzBuzz.Type type) {
		SharedPreferences.Editor preferences = getSharedPreferences(getString(R.string.config_file_key), Context.MODE_PRIVATE).edit();
		preferences.putString(getString(R.string.config_fizzBuzzType), type.toString());
		preferences.commit();
	}

	private static FizzBuzz.Type convertToType(int radioButtonId) {
		return radioButtonId == R.id.fizzBuzzRadioButton ? FizzBuzz.Type.FizzBuzz : FizzBuzz.Type.FizzBuzzWoof;
	}

	private static int convertToId(FizzBuzz.Type type) {
		return type == FizzBuzz.Type.FizzBuzz ? R.id.fizzBuzzRadioButton : R.id.fizzBuzzWoofRadioButton;
	}
}