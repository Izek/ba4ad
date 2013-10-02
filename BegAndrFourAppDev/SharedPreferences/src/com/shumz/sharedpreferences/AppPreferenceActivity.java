package com.shumz.sharedpreferences;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;


public class AppPreferenceActivity extends PreferenceActivity {
	
	@SuppressWarnings("deprecation")
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		PreferenceManager prefMgr = getPreferenceManager();
		prefMgr.setSharedPreferencesName("sharedPrefs");
		
		addPreferencesFromResource(R.xml.myapppreferences);
	}

}
