package com.shumz.intents;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class IntentsActivity extends Activity {

	int request_Code = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_intents);
	}

	public void onClickWebBrowser(View view) {
		Intent i = new Intent(android.content.Intent.ACTION_VIEW,
				Uri.parse("http://lurkmore.to"));
		startActivity(i);
	}

	public void onClickMakeCalls(View view) {
		Intent i = new Intent(android.content.Intent.ACTION_DIAL,
				Uri.parse("tel:+380968692099"));
		startActivity(i);
	}

	public void onClickShowMap(View view) {
		Intent i = new Intent(android.content.Intent.ACTION_VIEW,
				Uri.parse("geo:37.827500, -122.481670"));
		startActivity(i);
	}

	public void onClickLaunchBrowser(View view) {
		Intent i = new Intent("com.shumz.intents.BrowserActivity");
		i.setData(Uri
				.parse("http://lurkmore.to/%D0%90%D0%BD%D1%82%D0%B8-%D0%BF%D0%B0%D1%82%D1%82%D0%B5%D1%80%D0%BD"));
		startActivity(i);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
