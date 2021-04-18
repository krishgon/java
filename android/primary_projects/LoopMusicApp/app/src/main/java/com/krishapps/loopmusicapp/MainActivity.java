package com.krishapps.loopmusicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    Button button;
    SeekBar seekBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.controlButton);
        mediaPlayer = new MediaPlayer();
        seekBar = findViewById(R.id.seekBar2);

        try {
            mediaPlayer.setDataSource("https://pagalsong.in/uploads/systemuploads/mp3/Bachna%20Ae%20Haseeno/Khuda%20Jaane.mp3");
        } catch (IOException e) {
            e.printStackTrace();
        }

        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();

                seekBar.setMax(mediaPlayer.getDuration());
                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        if(fromUser){
                            mediaPlayer.seekTo(progress);
                        }
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });

            }
        });
        mediaPlayer.prepareAsync();

    }

    public void togglePlayer(View v){
        if(mediaPlayer.isPlaying()){
            mediaPlayer.pause();
            button.setText("Play");
        }
        else{
            mediaPlayer.start();
            button.setText("Pause");
        }
    }




}