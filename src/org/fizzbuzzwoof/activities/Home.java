package org.fizzbuzzwoof.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import org.fizzbuzzwoof.R;

public class Home extends Activity {
	@Override public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
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