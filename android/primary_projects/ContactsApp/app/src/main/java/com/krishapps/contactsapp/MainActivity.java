package com.krishapps.contactsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Contact o1 = new Contact("1", "1234567890", "Krish");
    Contact o2 = new Contact("2", "1234567890", "Krish");
    Contact o3 = new Contact("3", "1234567890", "Krish");
    Contact o4 = new Contact("4", "1234567890", "Krish");
    Contact o5 = new Contact("5", "1234567890", "Krish");
    Contact o6 = new Contact("6", "1234567890", "Krish");
    Contact o7 = new Contact("7", "1234567890", "Krish");
    Contact o8 = new Contact("8", "1234567890", "Krish");
    Contact o9 = new Contact("9", "1234567890", "Krish");
    Contact o10 = new Contact("10", "1234567890", "Krish");

    Contact [] contacts = {o1, o2, o3, o4, o5, o6, o7, o8, o9, o10};

    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        CustomAdapter ad = new CustomAdapter(contacts);
        recyclerView.setAdapter(ad);

    }
}