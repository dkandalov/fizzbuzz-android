package org.fizzbuzzwoof;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FizzBuzzHome extends Activity {
	@Override public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
	}

	public void userWantsToOpenZenMode(View view) {
		Intent intent = new Intent(this, FizzBuzzActivity.class);
		startActivity(intent);
	}

	public void userWantsToExit(View view) {
		finish();
	}
}