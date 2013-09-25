package com.shumz.daactionbar;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class DaActionBarActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_da_action_bar);

		final Button btn_action_bar_magic = (Button) findViewById(R.id.button_action_bar_magic);
		btn_action_bar_magic.setText("Hide Action Bar");

		final ActionBar actionBar = getActionBar();

		btn_action_bar_magic.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (actionBar.isShowing()) {
					btn_action_bar_magic.setText("Show Action Bar");
					actionBar.hide();
				} else {
					btn_action_bar_magic.setText("Hide Action Bar");
					actionBar.show();
				}
			}
		});
		{

		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
