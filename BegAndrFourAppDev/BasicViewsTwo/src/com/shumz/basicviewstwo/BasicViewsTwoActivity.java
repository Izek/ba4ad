package com.shumz.basicviewstwo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.widget.ProgressBar;

public class BasicViewsTwoActivity extends Activity {

	static int progress;
	ProgressBar progressBar;
	int progressStatus = 0;
	Handler handler = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_basic_views_two);

		progress = 0;
		progressBar = (ProgressBar) findViewById(R.id.progress_bar);
		progressBar.setMax(200);

		// ---do some work in background thread---
		new Thread(new Runnable() {
			@Override
			public void run() {

				// ---do some work here---
				while (progressStatus < 100) {
					progressStatus = doSomeWork();

					// ---Update the progress bar---
					handler.post(new Runnable() {
						public void run() {
							progressBar.setProgress(progressStatus);
						}
					});
				}

				// ---hides the progress bar---
				handler.post(new Runnable() {
					public void run() {
						// ---0 - VISIBLE; 4 - INVISIBLE; 8 - GONE---
						progressBar.setVisibility(View.GONE);
					}
				});

			}

			// ---do some long running work here---
			private int doSomeWork() {
				try {
					// ---simulate doing some work---
					Thread.sleep(250);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return ++progress;
			}
		}).start();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
