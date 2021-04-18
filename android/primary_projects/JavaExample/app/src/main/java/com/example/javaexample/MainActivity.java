package com.example.javaexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create a list of tracks
        List<Track> tracks = new ArrayList<>();
        tracks.add(new Track("Mobile", "Tommy"));
        tracks.add(new Track("Web", "Brian"));
        tracks.add(new Track("Games", "Colton"));

        // create a list of students
        List<String> students = Arrays.asList("Krish", "Anushree", "Gunit");

        // assign students to tracks and store in a map
        Map<String, Track> assignments = new HashMap<>();
        Random random = new Random();
        for(String student : students){
            int index = random.nextInt(tracks.size());
            assignments.put(student, tracks.get(index));
        }

        // print the result of assignments
        for(Map.Entry<String, Track> entry : assignments.entrySet()){
            Track track = entry.getValue();
            Log.d("krish", entry.getKey() + " got " + track.getName() + " with " + track.getName());
        }

    }
}