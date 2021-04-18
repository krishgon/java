package com.krishapps.musicapp;

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

        button = findViewById(R.id.togglePlayer_button);
        mediaPlayer = new MediaPlayer();
        seekBar = findViewById(R.id.seekBar);

    }


    public void PlaySong(View v){

        switch (v.getId()){
            case R.id.song1:
                startSong("https://pagalsong.in/uploads/systemuploads/mp3/Bachna%20Ae%20Haseeno/Khuda%20Jaane.mp3");
                break;

            case R.id.song2:
                startSong("https://jatt.download/music/data/Hindi_Movies/202010/Songs_of_Trance/128/Baithi_Hai_1.mp3");
                break;

            case R.id.song3:
                startSong("https://jatt.download/music/data/Hindi_Single/202007/Inshallah/128/Inshallah_1.mp3");
                break;
        }


    }

    public void startSong(String url){
        if(mediaPlayer.isPlaying()){ mediaPlayer.stop(); }

        try {
            mediaPlayer.setDataSource(url);
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

                TogglePlayerState();

            }
        });
        mediaPlayer.prepareAsync();

    }

    public void toggleButton(View v){
        TogglePlayerState();
    }


    public void TogglePlayerState(){
        if(mediaPlayer.isPlaying()){
            mediaPlayer.pause();
            button.setText("Play");
        }
        else {
            mediaPlayer.start();
            button.setText("Pause");
        }
    }



}