package com.shumz.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FragmentTwoActivity extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.activity_fragment_two, container,
				false);
	}

	@Override
	public void onStart() {
		super.onStart();
		Button btnGetText = (Button) getActivity().findViewById(
				R.id.activity_fragment_two_button);
		btnGetText.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				TextView lblSetText = (TextView) getActivity().findViewById(
						R.id.activity_fragment_one_label);
				Toast.makeText(getActivity(), lblSetText.getText(),
						Toast.LENGTH_SHORT).show();
			}
		});
	}
}
