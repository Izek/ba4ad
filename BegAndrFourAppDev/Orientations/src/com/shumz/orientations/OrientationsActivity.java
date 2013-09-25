package com.shumz.orientations;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class OrientationsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_orientations);

		Log.d("StateInfo", "onCreate() called...");
	}

	@Override
	protected void onDestroy() {
		Log.d("StateInfo", "onDestroy() called...");
		super.onDestroy();
	}

	@Override
	protected void onPause() {
		Log.d("StateInfo", "onPause() called...");
		super.onPause();
	}

	@Override
	protected void onRestart() {
		Log.d("StateInfo", "onRestart() called...");
		super.onRestart();
	}

	@Override
	protected void onResume() {
		Log.d("StateInfo", "onResume() called...");
		super.onResume();
	}

	@Override
	protected void onStart() {
		Log.d("StateInfo", "onStart() called...");
		super.onStart();
	}

	@Override
	protected void onStop() {
		Log.d("StateInfo", "onStop() called...");
		super.onStop();
	}

}
