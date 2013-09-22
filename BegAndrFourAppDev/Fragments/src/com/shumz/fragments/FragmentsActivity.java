package com.shumz.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.FragmentManager;
import android.view.Display;
import android.view.Menu;
import android.view.WindowManager;

public class FragmentsActivity extends Activity {

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		FragmentManager fragmentManager = getFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager
				.beginTransaction();

		// ---get the current display info---
		WindowManager wm = getWindowManager();
		Display d = wm.getDefaultDisplay();
		if (d.getWidth() > d.getHeight()) {
			// ---landscape mode---
			FragmentOneActivity fragment_one = new FragmentOneActivity();
			// android.R.id.content refers to the content view of the activity
			fragmentTransaction.replace(android.R.id.content, fragment_one);
		} else {
			FragmentTwoActivity fragment_two = new FragmentTwoActivity();
			fragmentTransaction.replace(android.R.id.content, fragment_two);
		}

		fragmentTransaction.commit();

	//	setContentView(R.layout.activity_fragments);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
