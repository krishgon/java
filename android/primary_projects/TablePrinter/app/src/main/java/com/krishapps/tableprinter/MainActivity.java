package com.krishapps.tableprinter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button printButton;
    private EditText tableOf_editText;
    private TextView table_textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        printButton = findViewById(R.id.printButton);
        tableOf_editText = findViewById(R.id.tableOf_editText);
        table_textView = findViewById(R.id.table_textView);
    }

    public void Print(View view){

        // store the number typed by user
        List<String> sentence = new ArrayList<>();
        int tableOf = Integer.parseInt(tableOf_editText.getText().toString());

        // create a single string of the whole table
        StringBuilder strbul = new StringBuilder();
        for(int i=1; i<=10; i++){
            strbul.append((tableOf + " multiplied by " + i + " is " + (tableOf*i)));
            strbul.append("\n");
        }
        strbul.setLength(strbul.length()-1);
        String table = strbul.toString();

        // set the text of table text view
        table_textView.setText(table);
    }


}