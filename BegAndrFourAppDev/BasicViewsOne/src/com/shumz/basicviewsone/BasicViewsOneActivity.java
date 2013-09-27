package com.shumz.basicviewsone;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ToggleButton;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

public class BasicViewsOneActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_basic_views_one);

		// ---Button view---
		Button btnOpen = (Button) findViewById(R.id.btn_open);
		btnOpen.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				DisplayToast("You have clicked the Open button");
			}

		});

		// ---Button view---
		Button btnSave = (Button) findViewById(R.id.btn_save);
		btnSave.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				DisplayToast("You have clicked the Save button");
			}
		});

		// ---CheckBox---
		CheckBox checkBoxAutoSave = (CheckBox) findViewById(R.id.chk_autosave);
		checkBoxAutoSave.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (((CheckBox) v).isChecked()) {
					DisplayToast("CheckBox is checked");
				} else {
					DisplayToast("CheckBox is unchecked");
				}
			}
		});

		// ---RadioButton---
		RadioGroup rGroup = (RadioGroup) findViewById(R.id.rdb_gp);
		rGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				RadioButton rbOne = (RadioButton) findViewById(R.id.rdb_one);
				if (rbOne.isChecked()) {
					DisplayToast("Option 1 checked!");
				} else {
					DisplayToast("Option 2 checked!");
				}
			}
		});

		// ---ToggleButton---
		ToggleButton toggleButton = (ToggleButton) findViewById(R.id.toggle);
		toggleButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (((ToggleButton) v).isChecked()) {
					DisplayToast("Toggle button is ON");
				} else {
					DisplayToast("Toggle button is OFF");
				}
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void DisplayToast(String msg) {
		Toast.makeText(getBaseContext(), msg, Toast.LENGTH_SHORT).show();

	}
}
