package com.example.lr1;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;


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