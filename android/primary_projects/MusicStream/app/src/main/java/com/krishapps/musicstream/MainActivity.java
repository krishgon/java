package com.krishapps.musicstream;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Button pp, current;
    SeekBar seekBar;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        current = null;
        pp = findViewById(R.id.togglePlayer_button);
        mediaPlayer = new MediaPlayer();
        seekBar = findViewById(R.id.seekBar);

        pp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                togglePlayer();
            }
        });

    }

    public void playSong(View v){
        if(current != null){
            current.setBackgroundColor(Color.parseColor("#FF6200EE"));
        }
        current = (Button) v;
        current.setBackgroundColor(Color.GREEN);

        switch (v.getId()){
            case R.id.song1:
                initSong("https://pagalsong.in/uploads/systemuploads/mp3/Bachna%20Ae%20Haseeno/Khuda%20Jaane.mp3");
                   break;
            case R.id.song2:
                initSong("https://jatt.download/music/data/Hindi_Movies/202010/Songs_of_Trance/128/Baithi_Hai_1.mp3");
                break;
            case R.id.song3:
                initSong("https://jatt.download/music/data/Hindi_Single/202007/Inshallah/128/Inshallah_1.mp3");
                break;
        }
    }

    public void initSong(String url){
        mediaPlayer.reset();

        try {
            mediaPlayer.setDataSource(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
                pp.setText("Pause");

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

//                togglePlayer();
                Log.d("krishlog", "onPrepared: reached here");
            }
        });
        mediaPlayer.prepareAsync();

    }

    public void togglePlayer(){
        if(mediaPlayer.isPlaying()){
            mediaPlayer.pause();
            pp.setText("Play");
        }
        else{
            mediaPlayer.start();
            pp.setText("Pause");
        }

    }

}