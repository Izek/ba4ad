package com.shumz.sharedpreferences;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SharedPreferencesActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shared_preferences);

	}

	public void onClickLoad(View view) {
		Intent i = new Intent(
				"com.shumz.sharedpreferences.AppPreferenceActivity");
		startActivity(i);
	}

	public void onClickDisplay(View view) {
		// Toast.makeText(getBaseContext(), "Sorry,  not implemented yet...",
		// Toast.LENGTH_SHORT).show();

		//com.shumz.sharedpreferences_preferences.xml

		
		SharedPreferences appPrefs = getSharedPreferences(
				"sharedPrefs", MODE_PRIVATE);
		DisplayText(appPrefs.getString("editTextPref", ""));
	}

	public void onClickModify(View view) {
		// Toast.makeText(getBaseContext(), "Sorry,  not implemented yet...",
		// Toast.LENGTH_SHORT).show();

		SharedPreferences appPrefs = getSharedPreferences("sharedPrefs", MODE_PRIVATE);
		SharedPreferences.Editor prefsEditor = appPrefs.edit();

		((EditText) findViewById(R.id.txtString)).getText().toString();
		prefsEditor.commit();
	}

	private void DisplayText(String string) {
		Toast.makeText(getBaseContext(), string, Toast.LENGTH_SHORT).show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.shared_preferences, menu);
		return true;
	}

}
