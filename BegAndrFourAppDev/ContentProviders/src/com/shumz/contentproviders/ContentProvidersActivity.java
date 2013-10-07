package com.shumz.contentproviders;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ContentProvidersActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_content_providers);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.content_providers, menu);
		return true;
	}

}
