package com.example.broadcastreceiversecondapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.btnSend);

        if(ActivityCompat.checkSelfPermission(this, "com.example.PERMISSION_TOAST") != PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(this, new String[]{"com.example.PERMISSION_TOAST"}, 1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("com.example.TOAST_MESSAGE");
                intent.putExtra("message", "I am from second application");
                intent.setPackage("com.example.broadcastreceivers");
                sendBroadcast(intent);
            }
        });
    }
}
