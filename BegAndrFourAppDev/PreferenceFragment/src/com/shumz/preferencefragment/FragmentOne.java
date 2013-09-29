package com.shumz.preferencefragment;

import android.os.Bundle;
import android.preference.PreferenceFragment;

public class FragmentOne extends PreferenceFragment {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// ---load the preferences from an XML file---
		addPreferencesFromResource(R.xml.preferences);
	}

}
