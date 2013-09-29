package com.shumz.dialogfragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

public class FragmentDialog extends DialogFragment {

	static FragmentDialog newInstance(String title) {

		FragmentDialog fragment = new FragmentDialog();
		Bundle args = new Bundle();
		args.putString("title", title);

		fragment.setArguments(args);

		return fragment;
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {

		String title = getArguments().getString("title");
		return new AlertDialog.Builder(getActivity())
				.setIcon(R.drawable.ic_launcher)
				.setTitle(title)
				.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						((DialogFragmentActivity) getActivity())
								.doPositiveClick();
					}
				})
				.setNegativeButton("Cancel",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {
								((DialogFragmentActivity) getActivity())
										.doNegativeClick();
							}
						}).create();
	}

}
