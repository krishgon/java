package com.krishapps.usangeet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class PlaySong extends AppCompatActivity {

    TextView textView, playerState;
    ImageView play, previous, next;
    HashMap<String, String> mySongs;
    String songKey;
    MediaPlayer mediaPlayer;
    SeekBar seekBar;
    Thread updateSeek;
    String[] songKeys;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_song);

        textView = findViewById(R.id.textView2);
        play = findViewById(R.id.play);
        previous = findViewById(R.id.previous);
        next = findViewById(R.id.next);
        seekBar = findViewById(R.id.seekBar);
        playerState = findViewById(R.id.playerState);

        Intent intent = getIntent();

        mySongs = (HashMap<String, String>) intent.getSerializableExtra("songDB");
        songKey = intent.getStringExtra("songKey");
        songKeys = intent.getStringArrayExtra("songNames");
        position = intent.getIntExtra("position", -1);
        Log.d("krishlog", "onCreate: the size is " + mySongs.size());

        textView.setText(songKey);
        textView.setSelected(true);

        mediaPlayer = new MediaPlayer();

        toggleSong(mySongs.get(songKey));

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleMPstate();
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position!=0){
                    position--;
                }
                else {
                    position = mySongs.size()-1;
                }
                songKey = songKeys[position];
                toggleSong(mySongs.get(songKey));
                textView.setText(songKey);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position!=(mySongs.size()-1)){
                    position++;
                }
                else {
                    position = 0;
                }
                songKey = songKeys[position];
                toggleSong(mySongs.get(songKey));
                textView.setText(songKey);
            }
        });



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mediaPlayer.stop();
        mediaPlayer.release();

        updateSeek.interrupt();
    }

    public void toggleMPstate(){
        if(mediaPlayer.isPlaying()){
            mediaPlayer.pause();
            play.setImageResource(R.drawable.play);
        }
        else{
            mediaPlayer.start();
            play.setImageResource(R.drawable.pause);
        }
    }

    public void toggleSong(String url){
        if (mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            playerState.setVisibility(View.VISIBLE);
            play.setImageResource(R.drawable.play);
        }
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
                playerState.setVisibility(View.INVISIBLE);
                seekBar.setMax(mediaPlayer.getDuration());

                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        mediaPlayer.seekTo(seekBar.getProgress());
                    }
                });

                updateSeek = new Thread(){
                    @Override
                    public void run() {
                        int currentPosition = 0;
                        try{
                            while(currentPosition<mediaPlayer.getDuration()){
                                currentPosition = mediaPlayer.getCurrentPosition();
                                seekBar.setProgress(currentPosition);
                                sleep(800);
                            }
                        }
                        catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                };
                updateSeek.start();
                play.setImageResource(R.drawable.pause);
            }
        });
        mediaPlayer.prepareAsync();
    }

}