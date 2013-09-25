package com.shumz.daactionbar;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class DaActionBarActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_da_action_bar);

		// ActionBar actionBar = getActionBar();
		// actionBar.hide();
		// actionBar.show();

		final ActionBar actionBar = getActionBar();

		final Button btn_action_bar_magic = (Button) findViewById(R.id.button_action_bar_magic);
		btn_action_bar_magic.setText("Hide Action Bar");
		btn_action_bar_magic.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (actionBar.isShowing()) {
					btn_action_bar_magic.setText("Show Action Bar");
					actionBar.hide();
				} else {
					btn_action_bar_magic.setText("Hide Action Bar");
					actionBar.show();
				}
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		CreateMenu(menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		return MenuChoise(item);
	}

	private void CreateMenu(Menu menu) {
		MenuItem mnu1 = menu.add(0, 0, 0, "Item 001");
		{
			mnu1.setIcon(R.drawable.ic_launcher);
			mnu1.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		}
		MenuItem mnu2 = menu.add(0, 1, 1, "Item 2");
		{
			mnu2.setIcon(R.drawable.ic_launcher);
			mnu2.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		}
		MenuItem mnu3 = menu.add(0, 2, 2, "Item 3");
		{
			mnu3.setIcon(R.drawable.ic_launcher);
			mnu3.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		}
		MenuItem mnu4 = menu.add(0, 3, 3, "Item 4");
		{
			mnu4.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		}
		MenuItem mnu5 = menu.add(0, 4, 4, "Item 5");
		{
			mnu5.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		}

	}

	private boolean MenuChoise(MenuItem item) {
		switch (item.getItemId()) {
		case 0:
			Toast.makeText(this, "You clicked on item 1", Toast.LENGTH_LONG)
					.show();
			return true;
		case 1:
			Toast.makeText(this, "You clicked on item 2", Toast.LENGTH_LONG)
					.show();
			return true;
		case 2:
			Toast.makeText(this, "You clicked on item 3", Toast.LENGTH_LONG)
					.show();
			return true;
		case 3:
			Toast.makeText(this, "You clicked on item 4", Toast.LENGTH_LONG)
					.show();
			return true;
		case 4:
			Toast.makeText(this, "You clicked on item 5", Toast.LENGTH_LONG)
					.show();
			return true;
		}
		return false;
	}

}
