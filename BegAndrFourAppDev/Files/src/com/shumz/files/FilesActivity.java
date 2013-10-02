package com.shumz.files;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class FilesActivity extends Activity {
	EditText textBox;
	static final int READ_BLOCK_SIZE = 100;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_files);

		textBox = (EditText) findViewById(R.id.etSomeText);
	}

	@SuppressLint("WorldReadableFiles")
	public void onClickSave(View view) {
		String str = textBox.getText().toString();
		try {
			@SuppressWarnings("deprecation")
			FileOutputStream fOut = openFileOutput("txtFile.txt",
					MODE_WORLD_READABLE);
			OutputStreamWriter osw = new OutputStreamWriter(fOut);

			// ---write the string to the file---
			osw.write(str);
			osw.flush();
			osw.close();

			// ---display file saved message---
			Toast.makeText(getBaseContext(), "File saved successfully!",
					Toast.LENGTH_SHORT).show();
			// ---clears the EditText---
			textBox.setText("");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onClickLoad(View view) {
		try {
			FileInputStream fIn = openFileInput("txtFile.txt");
			InputStreamReader isr = new InputStreamReader(fIn);

			char[] inputBuffer = new char[READ_BLOCK_SIZE];
			String str = "";

			int charRead;

			while ((charRead = isr.read(inputBuffer)) > 0) {
				// ---convert the chars to a String---
				String readString = String
						.copyValueOf(inputBuffer, 0, charRead);

				str += readString;

				inputBuffer = new char[READ_BLOCK_SIZE];
			}

			// ---set the EditText to the text that has been
			// read---
			textBox.setText(str);

			Toast.makeText(getBaseContext(), "File loaded successfully!",
					Toast.LENGTH_SHORT).show();

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.files, menu);
		return true;
	}

}
