package com.shumz.contentproviders;

import android.net.Uri;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentValues;
import android.content.CursorLoader;
import android.database.Cursor;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ContentProvidersActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_content_providers);
	}

	public void onClickAddTitle(View view) {
		// ---add a book---
		ContentValues values = new ContentValues();
		values.put(BooksProvider.TITLE,
				((EditText) findViewById(R.id.txtTitle)).getText().toString());
		values.put(BooksProvider.ISBN, ((EditText) findViewById(R.id.txtISBN))
				.getText().toString());
		Uri uri = getContentResolver()
				.insert(BooksProvider.CONTENT_URI, values);
		Toast.makeText(getBaseContext(), uri.toString(), Toast.LENGTH_SHORT)
				.show();
	}

	@SuppressLint("NewApi")
	@SuppressWarnings("deprecation")
	public void onClickRetrieveTitles(View view) { 
		// ---retrieve the titles---
		Uri allTitles = Uri
				.parse("content://com.shumz.provider.Books/books");
		Cursor c;
		if (android.os.Build.VERSION.SDK_INT < 11) {
			// ---before Honeycomb---
			c = managedQuery(allTitles, null, null, null, "title desc");
		} else {
			// ---Honeycomb and later---
			CursorLoader cursorLoader = new CursorLoader(this, allTitles, null,
					null, null, "title desc");
			c = cursorLoader.loadInBackground();
		}
		if (c.moveToFirst()) {
			do {
				Toast.makeText(
						this,
						c.getString(c.getColumnIndex(BooksProvider._ID))
								+ ", "
								+ c.getString(c
										.getColumnIndex(BooksProvider.TITLE))
								+ ", "
								+ c.getString(c
										.getColumnIndex(BooksProvider.ISBN)),
						Toast.LENGTH_SHORT).show();
			} while (c.moveToNext());
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.content_providers, menu);
		return true;
	}

}
