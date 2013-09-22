package com.shumz.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentOneActivity extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		Log.d("FragmentOneActivity", "onCreateView() called...");

		return inflater.inflate(R.layout.activity_fragment_one, container,
				false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		Log.d("FragmentOneActivity", "onActivityCreated() called...");

	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		Log.d("FragmentOneActivity", "onAttach() called...");
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d("FragmentOneActivity", "onCreate() called...");

	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.d("FragmentOneActivity", "onDestroy() called...");

	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		Log.d("FragmentOneActivity", "onDestroyView() called...");

	}

	@Override
	public void onDetach() {
		super.onDetach();
		Log.d("FragmentOneActivity", "onDetach() called...");

	}

	@Override
	public void onPause() {
		super.onPause();
		Log.d("FragmentOneActivity", "onPause() called...");

	}

	@Override
	public void onResume() {
		super.onResume();
		Log.d("FragmentOneActivity", "onResume() called...");

	}

	@Override
	public void onStart() {
		super.onStart();
		Log.d("FragmentOneActivity", "onStart() called...");

	}

	@Override
	public void onStop() {
		super.onStop();
		Log.d("FragmentOneActivity", "onStop() called...");

	}

}
