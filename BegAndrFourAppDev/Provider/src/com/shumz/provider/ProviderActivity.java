package com.shumz.provider;

import android.annotation.SuppressLint;
import android.app.ListActivity;
import android.content.CursorLoader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.CursorAdapter;
import android.widget.SimpleCursorAdapter;

public class ProviderActivity extends ListActivity {
	/** Called when the activity is first created. */
	@SuppressLint({ "InlinedApi", "NewApi" })
	@SuppressWarnings("deprecation")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_provider);

		// Uri allContacts = Uri.parse("content://contacts/people");
		Uri allContacts = ContactsContract.Contacts.CONTENT_URI;
		Cursor c;

		if (android.os.Build.VERSION.SDK_INT < 11) {
			// ---before Honeycomb---
			c = managedQuery(allContacts, null, null, null, null);
		} else {
			// ---Honeycomb and later---
			CursorLoader cursorLoader = new CursorLoader(this, allContacts,
					null, null, null, null);
			c = cursorLoader.loadInBackground();
		}

		String[] columns = new String[] {
				ContactsContract.Contacts.DISPLAY_NAME,
				ContactsContract.Contacts._ID };
		int[] views = new int[] { R.id.contactName, R.id.contactID };

		SimpleCursorAdapter adapter;

		if (android.os.Build.VERSION.SDK_INT < 11) {
			// ---before Honeycomb---
			adapter = new SimpleCursorAdapter(this, R.layout.activity_provider,
					c, columns, views);
		} else {
			// ---Honeycomb and later---
			adapter = new SimpleCursorAdapter(this, R.layout.activity_provider,
					c, columns, views,
					CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
		}

		this.setListAdapter(adapter);
		PrintContacts(c);
	}

	private void PrintContacts(Cursor c) {

		if (c.moveToFirst()) {
			do {
				String contactID = c.getString(c
						.getColumnIndex(ContactsContract.Contacts._ID));
				String contactDisplayName = c
						.getString(c
								.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));

				Log.v("Content Providers", contactID + ", "
						+ contactDisplayName);

				// ---get phone number---
				int hasPhone = c
						.getInt(c
								.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER));

				if (hasPhone == 1) {
					Cursor phoneCursor = getContentResolver().query(
							ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
							null,
							ContactsContract.CommonDataKinds.Phone.CONTACT_ID
									+ " = " + contactID, null, null);
					while (phoneCursor.moveToNext()) {
						Log.v("Content Provider",
								phoneCursor.getString(phoneCursor
										.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)));

					}
					phoneCursor.close();
				}

			} while (c.moveToNext());
		}
	}

}
