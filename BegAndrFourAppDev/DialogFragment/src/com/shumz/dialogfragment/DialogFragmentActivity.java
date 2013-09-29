package com.shumz.dialogfragment;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

public class DialogFragmentActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dialog_fragment);

		FragmentDialog dialogFragment = FragmentDialog
				.newInstance("Are you sure to do this?..");
		dialogFragment.show(getFragmentManager(), "dialog");
	}

	public void doPositiveClick() {
		// ---perform steps when user clicks on OK---
		Log.d("DialogFragmentExample", "User clicks on OK");
	}

	public void doNegativeClick() {
		// ---perform steps when user clicks on Cancel---
		Log.d("DialogFragmentExample", "User clicks on Cancel");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
