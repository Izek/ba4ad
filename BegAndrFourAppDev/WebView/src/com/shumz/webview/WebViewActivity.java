package com.shumz.webview;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web_view);

		WebView webView = (WebView) findViewById(R.id.webview1);
		WebSettings webSettings = webView.getSettings();
		webSettings.setBuiltInZoomControls(true);

		webView.loadUrl("file:///android_asset/Index.html");

		// final String mimeType = "text/html";
		// final String encoding = "UTF-8";
		// String html = "<H1>A simple HTML page</H1><body>" +
		// "<p>The quick brown fox jumps over the lazy dog</p>" +
		// "</body>";
		// webView.loadDataWithBaseURL("", html, mimeType, encoding, "");

		// webView.loadUrl("http://chart.apis.google.com/chart" + "?chs=300x225"
		// + "&cht=v" + "&chco=FF6342,ADDE63,63C6DE"
		// + "&chd=t:100,80,60,30,30,30,10" + "&chdl=A|B|C");

		// webView.setWebViewClient(new Callback());
		// webView.loadUrl("http://www.wrox.com");
	}

	@SuppressWarnings("unused")
	private class Callback extends WebViewClient {
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			return (false);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.web_view, menu);
		return true;
	}

}
