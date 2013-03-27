package org.fizzbuzzwoof.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import org.fizzbuzzwoof.R;

import static org.fizzbuzzwoof.businesslogic.FizzBuzz.fizzBuzz;

public class ZenMode extends Activity {
	private int counter = 0;

	@Override public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.zen_mode);

		TextView fizzBuzzText = (TextView) findViewById(R.id.zenModeFizzBuzzText);
		fizzBuzzText.setText(fizzBuzz(++counter));
	}

	public void fizzBuzzCount(View view) {
		TextView fizzBuzzText = (TextView) findViewById(R.id.zenModeFizzBuzzText);
		fizzBuzzText.setText(fizzBuzz(++counter));
	}
}
