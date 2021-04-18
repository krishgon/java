package com.krishapps.listviewmultiscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayMessage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent inti = getIntent();
        String message = inti.getStringExtra(MainActivity.EXTRA_MESSAGE);

        TextView message_textView = findViewById(R.id.message_textView);
        message_textView.setText(message);
    }
}