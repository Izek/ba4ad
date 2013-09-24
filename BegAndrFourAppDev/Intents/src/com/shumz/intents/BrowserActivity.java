package com.shumz.intents;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class BrowserActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_browser);

		Uri url = getIntent().getData();
		WebView webView = (WebView) findViewById(R.id.webView);
		webView.setWebViewClient(new Callback());

		webView.loadUrl(url.toString());

	}

	private class Callback extends WebViewClient {

		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			return (false);
		}
	}

}
