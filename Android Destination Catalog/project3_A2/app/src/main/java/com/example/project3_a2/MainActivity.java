package com.example.project3_a2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements fragment_a.fragmentAlistener{
    //ListView listView;
    private fragment_a fragmentA;



    @Override
    public void onListClick(int position) {
        if(position == 0){
            String url0 = "https://www.lpzoo.org/";
            Intent i0 = new Intent(Intent.ACTION_VIEW);
            i0.setData(Uri.parse(url0));
            startActivity(i0);
        }
        else if(position == 1){
            String url0 = "https://navypier.org/";
            Intent i0 = new Intent(Intent.ACTION_VIEW);
            i0.setData(Uri.parse(url0));
            startActivity(i0);
        }
        else if(position == 2){
            String url0 = "https://www.msichicago.org/";
            Intent i0 = new Intent(Intent.ACTION_VIEW);
            i0.setData(Uri.parse(url0));
            startActivity(i0);
        }
        else if(position == 3){
            String url0 = "https://www.artic.edu/";
            Intent i0 = new Intent(Intent.ACTION_VIEW);
            i0.setData(Uri.parse(url0));
            startActivity(i0);
        }
        else if(position == 4){
            String url0 = "https://www.mlb.com/cubs/ballpark/information";
            Intent i0 = new Intent(Intent.ACTION_VIEW);
            i0.setData(Uri.parse(url0));
            startActivity(i0);
        }

        else if(position == 5){
            String url0 = "https://www.mlb.com/whitesox/ballpark/information/guide";
            Intent i0 = new Intent(Intent.ACTION_VIEW);
            i0.setData(Uri.parse(url0));
            startActivity(i0);
        }

        else if(position == 6){
            String url0 = "https://www.chicago-theater.com/";
            Intent i0 = new Intent(Intent.ACTION_VIEW);
            i0.setData(Uri.parse(url0));
            startActivity(i0);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentA = new fragment_a();

        getSupportFragmentManager().beginTransaction().replace(R.id.containerA, fragmentA).commit();
        //listView= findViewById(R.id.listview);

        //ArrayList<String> arrayList = new ArrayList<>();
        /*
        arrayList.add("Lincoln Park Zoo");
        arrayList.add("Navy Pier");
        arrayList.add("Museum of Science and Industry");
        arrayList.add("Art Institute of Chicago");
        arrayList.add("Wrigley Field");
        */
    }
}
