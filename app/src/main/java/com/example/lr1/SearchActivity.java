package com.example.lr1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.app.Dialog;
import android.app.AlertDialog;
import androidx.annotation.NonNull;

import com.example.lr1.databinding.ActivitySearchBinding;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener {

    ActivitySearchBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySearchBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
}

    @Override
    public void onClick(View view) {
        if(view.getId()== binding.btnSearch.getId()){
        }


    }
}