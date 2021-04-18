package com.krishapps.sqlitedb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DbHandler handler = new DbHandler(this, "stdntDB", null, 1);
        handler.addStudent(new Student(2, "Gunit", 80.1));
        handler.getStudent(2);
        handler.close();

    }
}