package com.krishapps.sharedprefgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CountDownTimer timer;
    TextView time_textView, score_TextView, highScore_textView;
    Button start_Button;
    Boolean gameStarted = false;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start_Button = findViewById(R.id.start_Button);
        score_TextView = findViewById(R.id.score_TextView);
        time_textView = findViewById(R.id.time_textView);
        highScore_textView = findViewById(R.id.highScore_textView);

        SharedPreferences sharedPreferences = getSharedPreferences("myGame", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        highScore_textView.setText("High Score: " + sharedPreferences.getInt("highScore", 0));

        Log.d("krishlog", "onCreate: mai idhar fas gya");


        timer = new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                time_textView.setText("" + millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                gameStarted = false;
                time_textView.setText("You scored a total of " + score);
                if(score > sharedPreferences.getInt("highScore", 0)){
                    editor.putInt("highScore", score);
                    editor.apply();
                    highScore_textView.setText("High score: " + score);
                }
                score = 0;
            }
        };

        start_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameStarted = true;
                timer.start();
            }
        });


    }

    public void addScore(View v){
        if(gameStarted){
            score++;
            score_TextView.setText("" + score);
        }
    }




}