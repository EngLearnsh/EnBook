package com.englearnsh.enbook;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.DialogCompat;
import androidx.fragment.app.DialogFragment;

import java.util.Objects;

public class NewDownloadDialog extends DialogFragment {

    private EditText editText;
    private static final String DEBUG_TAG = "NewDownloadSample";

    /* The activity that creates an instance of this dialog fragment must
     * implement this interface in order to receive event callbacks.
     * Each method passes the DialogFragment in case the host needs to query it. */
    public interface NoticeDialogListener {
        public void onDialogPositiveClick(DialogFragment dialog);
        public void onDialogNegativeClick(DialogFragment dialog);
    }

    // Use this instance of the interface to deliver action events
    NoticeDialogListener listener;

    // Override the Fragment.onAttach() method to instantiate the NoticeDialogListener
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            listener = (NoticeDialogListener) context;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException("Must implement NoticeDialogListener");
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // Get the layout inflater
        LayoutInflater inflater = requireActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(inflater.inflate(R.layout.create_new_download, null))
                .setTitle(R.string.request_download)
                // Add action buttons
                .setPositiveButton(R.string.confirm_download, new DialogInterface.OnClickListener() {
                    @NonNull
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Confirm and start to download
                        editText = (EditText) getDialog().findViewById(R.id.new_download);
                        String inputText = editText.getText().toString();
                        Log.d(DEBUG_TAG, inputText + "000");
                        listener.onDialogPositiveClick(NewDownloadDialog.this);
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // User cancel
                        listener.onDialogNegativeClick(NewDownloadDialog.this);
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }

}