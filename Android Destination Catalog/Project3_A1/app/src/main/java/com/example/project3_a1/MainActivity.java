package com.example.project3_a1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    //private Button attractions;
    //private Button restaurants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //attractions = findViewById(R.id.attractions);
        //restaurants = findViewById(R.id.restaurants);

        /*
        attractions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendAttractions(v);
            }
        });

        restaurants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRestaurants(v);
            }
        });

         */

    }
    public void sendAttractions(View view){
        Intent intent = new Intent();
        ComponentName cn = new ComponentName("com.example.project3_a2", "com.example.project3_a2.MyReceiver");
        intent.setComponent(cn);
        sendBroadcast(intent);
    }

    public void sendRestaurants(View view){
        Intent intent = new Intent();
        ComponentName cn = new ComponentName("com.example.project3_a2", "com.example.project3_a2.MyReceiver");
        intent.setComponent(cn);
        sendBroadcast(intent);
    }
}
