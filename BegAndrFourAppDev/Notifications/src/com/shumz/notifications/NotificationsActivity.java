package com.shumz.notifications;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class NotificationsActivity extends Activity {

	private int notificationID = 1;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notifications);
	}

	public void onClick(View view) {
		displayNotification();
	}

	@SuppressWarnings("deprecation")
	protected void displayNotification() {
		// ---PendingIntent to launch activity if the user selects this
		// notification---
		Intent i = new Intent(this, NotificationViewActivity.class);
		i.putExtra("notificationID", notificationID);

		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, i, 0);

		NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

		Notification notif = new Notification(R.drawable.ic_launcher,
				"Reminder: Bomb explodes in 5 seconds",
				System.currentTimeMillis());

		CharSequence from = "System Alarm";
		CharSequence message = "Bomb explosion at 11pm...";

		notif.setLatestEventInfo(this, from, message, pendingIntent);

		// ---100ms delay, vibrate for 250ms, pause for 100 ms and
		// then vibrate for 500ms---

		notif.vibrate = new long[] { 100, 250, 100, 500, 100, 750 };
		nm.notify(notificationID, notif);
	}
}