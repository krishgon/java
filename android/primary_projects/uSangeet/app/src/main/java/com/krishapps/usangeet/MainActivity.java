package com.krishapps.usangeet;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    HashMap<String, String> songDB = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        Log.d("krishlog", "onCreate: initialised");

        songDB.put("Better", "https://mp3form.com/uploads/files/2020-09/1601105118_zayn_-_better.mp3");
        songDB.put("Spirits", "https://mp3form.com/uploads/files/2020-10/1601927154_the_strumbellas_-_spirits_zv_fm.mp3");
        songDB.put("Seven Nation Army", "https://mp3form.com/uploads/files/2020-09/1600985896_the_white_stripes_-_seven_nation_army_original_zf_fm.mp3");


        Dexter.withContext(this)
                .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
//                        Toast.makeText(MainActivity.this, "Runtime permission given", Toast.LENGTH_SHORT).show();

                        String[] songNames = songDB.keySet().toArray(new String[songDB.keySet().size()]);

                        Log.d("krishlog", "onPermissionGranted: " + songNames[1]);

                        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, songNames);
                        listView.setAdapter(adapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                Intent intent = new Intent(MainActivity.this, PlaySong.class);
                                String currentSong = listView.getItemAtPosition(position).toString();
                                Log.d("krishlog", "onItemClick: the position is " + position);
                                intent.putExtra("songDB", songDB);
                                intent.putExtra("songKey", currentSong);
                                intent.putExtra("songNames", songNames);
                                intent.putExtra("position", position);

                                startActivity(intent);
                            }
                        });
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                        permissionToken.continuePermissionRequest();
                    }
                })
                .check();
    }
}