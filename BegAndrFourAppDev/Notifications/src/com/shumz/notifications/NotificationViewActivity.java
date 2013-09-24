package com.shumz.notifications;

import android.app.Activity;
import android.app.NotificationManager;
import android.os.Bundle;

public class NotificationViewActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notification_view);

		// ---look up the notification manager service---
		NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

		// ---cancel the notification that we started---
		nm.cancel(getIntent().getExtras().getInt("notificationID"));
	}
}
