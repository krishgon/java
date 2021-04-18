package com.krishapps.numericplus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView answerTextView;
    private EditText number1, number2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void add(View view){
        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        answerTextView = findViewById(R.id.answerTextView);
//
//        String n1 = number1.getText().toString();
//        String n2 = number2.getText().toString();
//        int num1 = Integer.parseInt(n1);
//        int num2 = Integer.parseInt(n2);
//
        int sum = Integer.parseInt(number1.getText().toString()) + Integer.parseInt(number2.getText().toString());

        answerTextView.setText("The sum is " + sum);
    }

}