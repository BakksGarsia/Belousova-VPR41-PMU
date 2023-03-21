package com.example.lr1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class GraphicMediaActivity extends AppCompatActivity {

    MediaPlayer music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphic_media);

        music = MediaPlayer.create(this, R.raw.thehatters);

    }

    public void musicPlay(View view) {
        music.start();
    }

    public void musicPause(View view) {
        music.pause();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public void startFile(View view) {
        Intent intent = new Intent(this, FileActivity.class);
        startActivity(intent);
    }

}