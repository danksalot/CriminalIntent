package com.jacobdanks.android.criminalintent;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Jacob on 3/19/2018.
 */

public class CrimePhotoFragment extends DialogFragment {
    private static final String ARG_PATH = "path";
    private static final String ARG_TITLE = "title";

    private ImageView mPhotoView;

    public static CrimePhotoFragment newInstance(String path, String title) {
        Bundle args = new Bundle();
        args.putString(ARG_PATH, path);
        args.putString(ARG_TITLE, title);

        CrimePhotoFragment fragment = new CrimePhotoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        String path = getArguments().getString(ARG_PATH);
        String title = getArguments().getString(ARG_TITLE);

        View v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_photo, null);

        mPhotoView = v.findViewById(R.id.dialog_photo);
        Bitmap bitmap = PictureUtils.getScaledBitmap(path, getActivity());
        mPhotoView.setImageBitmap(bitmap);

        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .setTitle(title)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        return;
                    }
                })
                .create();
    }
}
