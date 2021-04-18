package com.krishapps.horizontalscrollapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void message(View view){
        Toast toast = Toast.makeText(MainActivity.this, "The button is clicked", Toast.LENGTH_SHORT);
        toast.show();
    }
}