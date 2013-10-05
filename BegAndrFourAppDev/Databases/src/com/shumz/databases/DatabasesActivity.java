package com.shumz.databases;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

public class DatabasesActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_databases);

		DBAdapter db = new DBAdapter(this);
		try {
			String destPath = "/data/data" + getPackageName() + "/databases";
			File f = new File(destPath);
			if (!f.exists()) {
				f.mkdirs();
				f.createNewFile();

				// ---copy the db from the assets folder into
				// the databases folder---
				CopyDB(getBaseContext().getAssets().open("my_db"),
						new FileOutputStream(destPath + "MyDB"));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// // ---add a contact---
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

		// // ---delete a contact---
		// db.open();
		// if (db.deleteContact(1)) {
		// Toast.makeText(this, "Delete successful!..", Toast.LENGTH_SHORT)
		// .show();
		// } else {
		// Toast.makeText(this, "Delete failed...", Toast.LENGTH_SHORT).show();
		//
		// }

	}

	private void CopyDB(InputStream inputStream, FileOutputStream outputStream)
			throws IOException {
		// ---copy 1K bytes at a time---
		byte[] buffer = new byte[1024];
		int length;
		while ((length = inputStream.read(buffer)) > 0) {
			outputStream.write(buffer, 0, length);
		}

		inputStream.close();
		outputStream.close();
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
