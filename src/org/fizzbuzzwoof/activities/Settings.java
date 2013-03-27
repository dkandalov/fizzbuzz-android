package org.fizzbuzzwoof.activities;

import android.app.Activity;
import android.os.Bundle;
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

	private static int convertToId(FizzBuzz.Type type) {
		return type == FizzBuzz.Type.FizzBuzz ? R.id.fizzBuzzRadioButton : R.id.fizzBuzzWoofRadioButton;
	}
}