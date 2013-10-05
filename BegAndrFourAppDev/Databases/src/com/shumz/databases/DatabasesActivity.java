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

		// // ---get all contacts---
		// db.open();
		// Cursor c = db.getAllContacts();
		// if (c.moveToFirst()) {
		// do {
		// DisplayContact(c);
		//
		// } while (c.moveToNext());
		// }
		// db.close();

		// // ---get a contact---
		// db.open();
		// Cursor c = db.getContact(2);
		// if (c.moveToFirst()) {
		// DisplayContact(c);
		// } else {
		// Toast.makeText(this, "No contact found...", Toast.LENGTH_SHORT)
		// .show();
		// }

		// // ---update contact---
		// db.open();
		// if (db.updateContact(4, "Izek Schum", "izek.schum@gmail.com")) {
		// Toast.makeText(this, "Update successful!..", Toast.LENGTH_SHORT)
		// .show();
		// } else {
		// Toast.makeText(this, "Update failed...", Toast.LENGTH_SHORT).show();
		// }

		// ---delete a contact---
		db.open();
		if (db.deleteContact(1)) {
			Toast.makeText(this, "Delete successful!..", Toast.LENGTH_SHORT)
					.show();
		} else {
			Toast.makeText(this, "Delete failed...", Toast.LENGTH_SHORT).show();

		}

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
