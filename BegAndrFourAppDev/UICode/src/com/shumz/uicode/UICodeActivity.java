package com.shumz.uicode;

import android.os.Bundle;

import android.app.Activity;
import android.view.Menu;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class UICodeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.activity_main);
		// ---param for views---
		LayoutParams params = new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);

		// ---create a layout---
		LinearLayout layout = new LinearLayout(this);
		layout.setOrientation(LinearLayout.VERTICAL);

		// ---create a textview---
		TextView tv = new TextView(this);
		tv.setText("This is a TextView");
		tv.setLayoutParams(params);

		// ---create a button---
		Button btn = new Button(this);
		btn.setText("This is a Button");
		btn.setLayoutParams(params);

		// ---adds the textview---
		layout.addView(tv);

		// ---adds the button---
		layout.addView(btn);

		// ---create a layout param for the layout---
		LinearLayout.LayoutParams layoutParam = new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);

		this.addContentView(layout, layoutParam);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
