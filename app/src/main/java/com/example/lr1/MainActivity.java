package com.example.lr1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnStart = (Button) findViewById(R.id.btnActivityPage);
        btnStart.setOnClickListener(this::onClick);
    }
    public void onClick (View view){
        Intent intent;
        intent = new Intent(this,LogInPageActivity.class);
        startActivity(intent);
    }
}