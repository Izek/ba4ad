package com.shumz.sharedpreferences;

import android.os.Bundle;
import android.preference.PreferenceActivity;


public class AppPreferenceActivity extends PreferenceActivity {
	
	@SuppressWarnings("deprecation")
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		addPreferencesFromResource(R.xml.myapppreferences);
	}

}
