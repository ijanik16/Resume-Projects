package com.example.project3_a2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, "Broadcast Received", Toast.LENGTH_LONG).show();
        //Intent i = new Intent();
        //i.setClassName("com.example.project_a2", "com.example.project_a2.MainActivity");
        //i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //context.startActivity(i);

    }
}
