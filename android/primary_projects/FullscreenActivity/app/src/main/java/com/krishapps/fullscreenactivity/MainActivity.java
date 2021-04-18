package com.krishapps.fullscreenactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    TextView question_textView;
    TextView opinionFeedback_textView;
    Button yes_button;
    Button no_button;
    String answer = null;
    int questionNumber = 0;
    int score = 0;
    String[] questions = {"Are you satisfied with politics of India?", "Do you think young people have sufficient representation in the parliament?", "Do you follow politics?"} ;
    String[] answers = {"no", "no", "yes"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        question_textView = findViewById(R.id.question_textView);
        yes_button = findViewById(R.id.yes_button);
        no_button = findViewById(R.id.no_button);
        opinionFeedback_textView = findViewById(R.id.opinionFeedback_textView);
    }

    public void chosen(View v){



        // set the answer to the answer chosen by user
            if (v.getId() == R.id.yes_button) {
                answer = "yes";
            } else {
                answer = "no";
            }

        // give feedback to the user based on the user correctness of the answer
            if(questionNumber<3) {
                if (answer == answers[questionNumber]) {
                    opinionFeedback_textView.setText("You have a great perspective");
                    score++;
                } else {
                    opinionFeedback_textView.setText("Please research more and think about the question");
                }
            }
        // change the current question to the next question
            questionNumber++;
            if(questionNumber<3) {
                question_textView.setText(questions[questionNumber]);
            }

        Log.d("krishlog", "question: " + questionNumber);
        Log.d("krishlog", "score: " + score);
        if(questionNumber > 2){
            Toast.makeText(this, "Your score is " + score, Toast.LENGTH_SHORT).show();
        }

    }
}