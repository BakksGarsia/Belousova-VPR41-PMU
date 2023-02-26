package com.example.lr1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import androidx.annotation.NonNull;

public class MenuDialogMessage extends AppCompatActivity {

    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_menu_dialog_message);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    public class SomeDialogFragment extends DialogFragment {

        public Dialog onCreateDialog(Bundle savedInstanceState) {
            AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
            return builder
                    .setTitle("One question")
                    .setMessage("is it a dialog?")
                    .setView(R.layout.activity_search)
                    .setPositiveButton("Yes", null)
                    .setNegativeButton("No", null)
                    .create();
        }
        public void showDialog(View v) {
            SomeDialogFragment dialog = new SomeDialogFragment();
            dialog.show(getSupportFragmentManager(), "some");
        }


    }
}