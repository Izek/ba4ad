package com.shumz.provider;

import android.annotation.SuppressLint;
import android.app.ListActivity;
import android.content.CursorLoader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
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
		Uri allContacts = Uri.parse("content://contacts/people");
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
	}

}
