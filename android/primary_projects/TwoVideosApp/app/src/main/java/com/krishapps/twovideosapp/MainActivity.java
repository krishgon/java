package com.krishapps.twovideosapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    SurfaceView s1, s2;
    MediaPlayer mp1, mp2;
    Button b1, b2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        s1 = findViewById(R.id.video1_view);
        s2 = findViewById(R.id.video2_view);
        b1 = findViewById(R.id.vid1_button);
        b2 = findViewById(R.id.vid2_button);

        mp1 = MediaPlayer.create(this, R.raw.video1);
        mp2 = MediaPlayer.create(this, R.raw.video2);

        s1.setKeepScreenOn(true);
        s2.setKeepScreenOn(true);

        SurfaceHolder s1h = s1.getHolder();
        SurfaceHolder s2h = s2.getHolder();

        s1h.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(@NonNull SurfaceHolder holder) {
                mp1.setDisplay(s1h);
            }

            @Override
            public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

            }
        });


        s2h.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(@NonNull SurfaceHolder holder) {
                mp2.setDisplay(s2h);
            }

            @Override
            public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

            }
        });

    }


    public void toggleMP_state(View v){

        if(mp1.isPlaying()){ mp1.pause(); }
        if(mp2.isPlaying()){ mp2.pause(); }

//        mp1.start();

        switch (v.getId()){
            case R.id.vid1_button:
                mp1.start();
                break;

            case R.id.vid2_button:
                mp2.start();
                break;

        }
    }
}