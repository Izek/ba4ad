package com.shumz.basicviewsfive;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class BasicViewsFiveActivity extends ListActivity {

	String[] presidents = { "Dwight D. Eisenhower", "John F. Kennedy",
			"Lyndon B. Johnson", "Richard Nixon", "Gerald Ford",
			"Jimmy Carter", "Ronald Reagan", "George H. W. Bush",
			"Bill Clinton", "George W. Bush", };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.activity_basic_views_five);

		setListAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, presidents));

	}

	public void onListItemClick(ListView parent, View v, int position, long id) {
		Toast.makeText(this, "You have selected " + presidents[position],
				Toast.LENGTH_SHORT).show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.basic_views_five, menu);
		return true;
	}

}
