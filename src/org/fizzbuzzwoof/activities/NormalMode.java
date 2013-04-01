package org.fizzbuzzwoof.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import org.fizzbuzzwoof.R;
import org.fizzbuzzwoof.businesslogic.FizzBuzz;
import org.fizzbuzzwoof.businesslogic.NormalModeGame;

import static android.view.Gravity.CENTER_HORIZONTAL;
import static android.view.View.INVISIBLE;
import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

public class NormalMode extends Activity {
	private static final int ONE_SECOND = 1000;

	// thread-confined to UI thread
	private final NormalModeGame game = new NormalModeGame(FizzBuzz.type);
	private UIThreadTimer uiThreadTimer;

	@Override public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.normal_mode);

		createLabels();
		updateSecondsLabel(game.timeLeft());
		updateScoreLabel(game.score());

		uiThreadTimer = new UIThreadTimer(ONE_SECOND, new Handler() {
			@Override public void handleMessage(Message msg) {
				game.oneSecondHasPassed();
				updateSecondsLabel(game.timeLeft());
				String message = game.messageForUser();
				if (message != null) {
					new MessageDialog(message, NormalMode.this).showAndInvoke(new Runnable() {
						@Override public void run() {
							if (game.isOver()) finish();
						}
					});
				}
			}
		}).start();
	}

	@Override protected void onDestroy() {
		super.onDestroy();
		uiThreadTimer.stop();
	}

	private void updateScoreLabel(String score) {
		TextView secondsLeftText = (TextView) findViewById(R.id.normalModeScoreText);
		secondsLeftText.setText("Score: " + score);
	}

	private void updateSecondsLabel(String timeLeft) {
		TextView secondsLeftText = (TextView) findViewById(R.id.normalModeSecondsLeftText);
		secondsLeftText.setText("Time: " + timeLeft);
	}

	private void createLabels() {
		LinearLayout layout = (LinearLayout) findViewById(R.id.normalModeLayout);
		layout.removeAllViews();
		for (final String s : game.allPossibleMoves()) {
			final TextView textView = new TextView(this);
			textView.setText(s);
			textView.setGravity(CENTER_HORIZONTAL);
			textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 30);
			textView.setOnClickListener(new View.OnClickListener() {
				@Override public void onClick(View view) {
					boolean moveWasCorrect = game.userMadeMove(s);
					if (moveWasCorrect) {
						createLabels();
					} else {
						textView.setVisibility(INVISIBLE);
					}
					updateScoreLabel(game.score());
				}
			});
			layout.addView(textView, new LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT));
		}
	}

	private static class MessageDialog extends DialogFragment {
		private final Activity activity;
		private final String message;
		private Runnable callback;

		private MessageDialog(String message, Activity activity) {
			this.activity = activity;
			this.message = message;
		}

		@Override public Dialog onCreateDialog(Bundle savedInstanceState) {
			return new AlertDialog.Builder(getActivity())
					.setMessage(message)
					.setPositiveButton("OK", new DialogInterface.OnClickListener() {
						@Override public void onClick(DialogInterface dialog, int id) {
							callback.run();
						}
					}).create();
		}

		public void showAndInvoke(Runnable callback) {
			this.callback = callback;
			show(activity.getFragmentManager(), "");
		}
	}

	private static class UIThreadTimer {
		private final int delayBetweenEventsInMillis;
		private final Handler handler;
		private volatile boolean shouldStop;

		public UIThreadTimer(int delayBetweenEventsInMillis, Handler handler) {
			this.delayBetweenEventsInMillis = delayBetweenEventsInMillis;
			this.handler = handler;
		}

		public UIThreadTimer start() {
			new Thread(new Runnable() {
				@Override public void run() {
					try {
						while (!shouldStop) {
							handler.obtainMessage().sendToTarget();
							Thread.sleep(delayBetweenEventsInMillis);
						}
					} catch (InterruptedException ignored) {
					}
				}
			}).start();
			return this;
		}

		public void stop() {
			shouldStop = true;
		}
	}
}
