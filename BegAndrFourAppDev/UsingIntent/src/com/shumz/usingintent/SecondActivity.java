package com.shumz.usingintent;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SecondActivity extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
	}
	
	public void onClick(View v) {
		Intent data = new Intent();
		
		EditText txt_username = (EditText) findViewById(R.id.txt_username);
		
		data.setData(Uri.parse(txt_username.getText().toString()));
		
		setResult(RESULT_OK, data);
		
		finish();
	}
}