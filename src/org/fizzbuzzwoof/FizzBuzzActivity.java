package org.fizzbuzzwoof;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FizzBuzzActivity extends Activity {
	private int counter = 0;

	@Override public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		TextView fizzBuzzText = (TextView) findViewById(R.id.fizzBuzzText);
		fizzBuzzText.setText(fizzBuzz(++counter));
	}

	public void fizzBuzzCount(View view) {
		TextView fizzBuzzText = (TextView) findViewById(R.id.fizzBuzzText);
		fizzBuzzText.setText(fizzBuzz(++counter));
	}

	private static String fizzBuzz(int counter) {
		if (counter % 3 == 0 && counter % 5 == 0) return "FizzBuzz";
		else if (counter % 3 == 0) return "Fizz";
		else if (counter % 5 == 0) return "Buzz";
		else return String.valueOf(counter);
	}

}
