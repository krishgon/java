package com.krishapps.recyclerviewcommercial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    RecyclerView contactsList_recyclerView;
    Contact[] contactsList = new Contact[15];




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactsList[0] = new Contact("1", "9285276039", "Krish Agrawal");
        contactsList[1] = new Contact("2", "9326811779", "Shailesh Agrawal");
        contactsList[2] = new Contact("3", "9372611779", "Sandhya Agrawal");
        contactsList[3] = new Contact("4", "1234567890", "Shlok Agrawal");
        contactsList[4] = new Contact("5", "1234567890", "Shlok Agrawal");
        contactsList[5] = new Contact("6", "1234567890", "Shlok Agrawal");
        contactsList[6] = new Contact("7", "1234567890", "Shlok Agrawal");
        contactsList[7] = new Contact("8", "1234567890", "Shlok Agrawal");
        contactsList[8] = new Contact("9", "1234567890", "Shlok Agrawal");
        contactsList[9] = new Contact("10", "1234567890", "Shlok Agrawal");
        contactsList[10] = new Contact("11", "1234567890", "Shlok Agrawal");
        contactsList[11] = new Contact("12", "1234567890", "Shlok Agrawal");
        contactsList[12] = new Contact("13", "1234567890", "Shlok Agrawal");
        contactsList[13] = new Contact("14", "1234567890", "Shlok Agrawal");
        contactsList[14] = new Contact("15", "1234567890", "Shlok Agrawal");

        Log.d("krishlog", contactsList[2].getName());

        contactsList_recyclerView = findViewById(R.id.contactsList_recyclerView);
        contactsList_recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ContactAdapter ad = new ContactAdapter(contactsList);

        Log.d("krishlog", "Reached the first checkpoint");

        contactsList_recyclerView.setAdapter(ad);
        contactsList_recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }
}