package com.shumz.uiactivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UIActivityActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ui_activity);

		// ---the two buttons are wired to the same event handler---

		Button btn_ok = (Button) findViewById(R.id.btnOK);
		btn_ok.setOnClickListener(btnListener);

		Button btn_cancel = (Button) findViewById(R.id.btnCancel);
		btn_cancel.setOnClickListener(btnListener);

		// ---create an anonymous inner class to act as an onfocus listener---
		EditText etUsername = (EditText) findViewById(R.id.etUserName);
		etUsername.setOnFocusChangeListener(new View.OnFocusChangeListener() {

			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				Toast.makeText(getBaseContext(), ((EditText) v).getId() + " has focus...",
						Toast.LENGTH_SHORT).show();
			}
		});
	}

	// ---create an anonymous class to act as a button click listener---
	private OnClickListener btnListener = new OnClickListener() {
		public void onClick(View view) {
			Toast.makeText(getBaseContext(),
					((Button) view).getText() + " was clicked...",
					Toast.LENGTH_SHORT).show();
		}
	};

	public boolean onKeyDown(int keyCode, KeyEvent event) {
		switch (keyCode) {
		case KeyEvent.KEYCODE_DPAD_CENTER:
			Toast.makeText(getBaseContext(), "Center was clicked",
					Toast.LENGTH_SHORT).show();
			break;
		// return true;
		case KeyEvent.KEYCODE_DPAD_LEFT:
			Toast.makeText(getBaseContext(), "Left arrow was clicked",
					Toast.LENGTH_SHORT).show();
			break;
		// return true;
		case KeyEvent.KEYCODE_DPAD_RIGHT:
			Toast.makeText(getBaseContext(), "Right arrow was clicked",
					Toast.LENGTH_SHORT).show();
			break;
		// return true;
		case KeyEvent.KEYCODE_DPAD_UP:
			Toast.makeText(getBaseContext(), "Up arrow was clicked",
					Toast.LENGTH_SHORT).show();
			break;
		// return true;
		case KeyEvent.KEYCODE_DPAD_DOWN:
			Toast.makeText(getBaseContext(), "Down arrow was clicked",
					Toast.LENGTH_SHORT).show();
			break;
		// return true;
		}
		return false;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
