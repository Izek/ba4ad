package com.shumz.databases;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.view.Menu;
import android.widget.Toast;

public class DatabasesActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_databases);

		DBAdapter db = new DBAdapter(this);

		// ---add a contact---
		// db.open();
		// long id = db.insertContact("Izek Schum", "izek.schum@gmail.com");
		// id = db.insertContact("Mary Jackson", "mary@jackson.com");
		// db.close();

		// ---get all contacts---
		db.open();
		Cursor c = db.getAllContacts();
		if (c.moveToFirst()) {
			do {
				DisplayContact(c);

			} while (c.moveToNext());
		}
		db.close();
	}

	public void DisplayContact(Cursor c) {
		Toast.makeText(
				this,
				"id: " + c.getString(0) + "\n" + "Name: " + c.getString(1)
						+ "\n" + "Email: " + c.getString(2), Toast.LENGTH_SHORT)
				.show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.databases, menu);
		return true;
	}

}
