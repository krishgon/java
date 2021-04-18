package com.krishapps.unconvert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    // declare components of the layout for use
    private EditText kgEditText;
    private TextView poundTextView;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // allocate the components in the class container for further use
        kgEditText = findViewById(R.id.kgEditText);
        poundTextView = findViewById(R.id.poundTextView);
        submitButton = findViewById(R.id.submitButton);

//        submitButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                Toast.makeText(MainActivity.this, "click listener worked!", Toast.LENGTH_SHORT).show();
//
//                // convert the kg value by user into pound value
//                String s = kgEditText.getText().toString(); // take the input from the user and store it in a string object
//                int kgValue = Integer.parseInt(s); // convert the string into integer
//                double poundValue = kgValue * 2.205; // convert the kg integer into decimal (double) pound
//                DecimalFormat df = new DecimalFormat("##.##");
//
//                // show the corresponding value in pounds to the user
//                poundTextView.setText("The corresponding value in pound is " + df.format(poundValue));
//            }
//        });
    }

    public void Calculate(View view){
        // convert the kg value by user into pound value
        String s = kgEditText.getText().toString(); // take the input from the user and store it in a string object
        int kgValue = Integer.parseInt(s); // convert the string into integer
        double poundValue = kgValue * 2.205; // convert the kg integer into decimal (double) pound
        DecimalFormat df = new DecimalFormat("##.##");

        // show the corresponding value in pounds to the user
        poundTextView.setText("The corresponding value in pound is " + df.format(poundValue));
    }
}