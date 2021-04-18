package com.krishapps.emailapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText email_editText;
    EditText subject_editText;
    EditText message_editText;
    Button send_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email_editText = findViewById(R.id.email_editText);
        subject_editText = findViewById(R.id.subject_editText);
        message_editText = findViewById(R.id.message_editText);
        send_button = findViewById(R.id.send_button);
    }

    public void send(View v){

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_EMAIL, email_editText.getText().toString());
        intent.putExtra(Intent.EXTRA_SUBJECT, subject_editText.getText().toString());
        intent.putExtra(Intent.EXTRA_TEXT, message_editText.getText().toString());
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

}