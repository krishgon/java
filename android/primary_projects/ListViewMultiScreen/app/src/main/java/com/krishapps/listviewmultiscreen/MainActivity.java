package com.krishapps.listviewmultiscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView options;
    public static String EXTRA_MESSAGE = "com.krishapps.listviewmultiscreen.MESSAGE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] items = {"option 1", "option 2", "option 3", "option 4", "option 5", "option 6", "option 7", "option 8", "option 9", "option 10", "option 11", "option 12", "option 13"};

        options = findViewById(R.id.options);

        myAdapterListView ad = new myAdapterListView(this, R.layout.krishbasic_layout, items);

        options.setAdapter(ad);
        options.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                displayMessage(position);

            }
        });

    }


    public void displayMessage(int position) {
        Intent intent = new Intent(MainActivity.this, DisplayMessage.class);
        String message = "You are here from option " + (position+1);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

}