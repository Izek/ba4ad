package com.shumz.databases;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class DatabasesActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_databases);

		DBAdapter db = new DBAdapter(this);

		// ---add a contact---
		db.open();
		long id = db.insertContact("Izek Schum", "izek.schum@gmail.com");
		id = db.insertContact("Mary Jackson", "mary@jackson.com");
		db.close();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.databases, menu);
		return true;
	}

}
