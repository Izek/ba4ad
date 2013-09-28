package com.shumz.basicviewsfour;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

public class BasicViewsFourActivity extends Activity {
	TimePicker tPicker;

	int hour, minute;
	static final int TIME_DIALOG_ID = 0;

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_basic_views_four);

		tPicker = (TimePicker) findViewById(R.id.timePicker);
		tPicker.setIs24HourView(true);

		showDialog(TIME_DIALOG_ID);
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case TIME_DIALOG_ID:
			return new TimePickerDialog(this, mTimeSetListener, hour, minute,
					false);
		default:
			break;
		}

		return null;

	}

	private TimePickerDialog.OnTimeSetListener mTimeSetListener = new TimePickerDialog.OnTimeSetListener() {

		@Override
		public void onTimeSet(TimePicker view, int hourOfDay, int minuteOfHour) {
			hour = hourOfDay;
			minute = minuteOfHour;

			SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm aa");
			Date date = new Date(0,0,0, hour, minute);
			String strDate = timeFormat.format(date);
			
			Toast.makeText(getBaseContext(), "You have selected: " + strDate, Toast.LENGTH_SHORT).show();
			
			
		}
	};

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
