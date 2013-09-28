package com.shumz.basicviewsfour;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

public class BasicViewsFourActivity extends Activity {
	TimePicker tPicker;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_basic_views_four);

		tPicker = (TimePicker) findViewById(R.id.timePicker);
		tPicker.setIs24HourView(true);

	}

	public void onClickSetTime(View view) {
		Toast.makeText(
				getApplicationContext(),
				"Time is set to: " + tPicker.getCurrentHour() + "h "
						+ tPicker.getCurrentMinute() + "m", Toast.LENGTH_SHORT)
				.show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.basic_views_four, menu);
		return true;
	}

}
