package org.fizzbuzzwoof.activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import org.fizzbuzzwoof.R;
import org.fizzbuzzwoof.businesslogic.FizzBuzz;

import static android.view.Gravity.CENTER_HORIZONTAL;
import static android.view.View.INVISIBLE;
import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

public class NormalMode extends Activity {
	private static int INITIAL_VALUE = 1;
	private int counter = INITIAL_VALUE;

	@Override public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.normal_mode);

		createLabels();
	}

	private void createLabels() {
		LinearLayout layout = (LinearLayout) findViewById(R.id.normalModeLayout);
		layout.removeAllViews();
		for (final String s : FizzBuzz.type.allChoices(counter)) {
			final TextView textView = new TextView(this);
			textView.setText(s);
			textView.setGravity(CENTER_HORIZONTAL);
			textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 30);
			textView.setOnClickListener(new View.OnClickListener() {
				@Override public void onClick(View view) {
					if (FizzBuzz.type.isCorrectAnswer(s, counter)) {
						counter++;
						createLabels();
					} else {
						textView.setVisibility(INVISIBLE);
					}
				}
			});
			layout.addView(textView, new LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT));
		}
	}
}
