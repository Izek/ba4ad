package com.shumz.usingintent;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class FirstActivity extends Activity {

	int request_Code = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first);

	}

	public void onClick(View v) {
		// startActivity(new Intent("com.shumz.usingintent.SecondActivity"));
		// startActivity(new Intent(this, SecondActivity.class));

		startActivityForResult(new Intent(
				"com.shumz.usingintent.SecondActivity"), request_Code);

	}

	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == request_Code) {
			if (resultCode == RESULT_OK) {
				if (data.getData().toString().length() == 0) {
					Toast.makeText(this, "Hello, Anonimous!..",
							Toast.LENGTH_SHORT).show();

				} else {
					Toast.makeText(this, data.getData().toString(),
							Toast.LENGTH_SHORT).show();
				}
			}
		}

	}

	public void onClickToExit(View v) {
		finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
