package com.krishapps.firstmultiscreenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "com.krishapps.firstmultiscreenapp.NAME";
    EditText personName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openActivity(View view){
        Toast.makeText(this, "Opening Second Activity", Toast.LENGTH_SHORT).show();

        personName = findViewById(R.id.personName_editText);
        String name = personName.getText().toString();
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra(EXTRA_NAME, name);
        startActivity(intent);
    }
}