package com.example.pavithra.fixedme2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MyRepairs extends AppCompatActivity {
    public static String vehicleNo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_repairs);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        vehicleNo=message;
        // Capture the layout's TextView and set the string as its text
        //TextView textView = findViewById(R.id.txtWelcome);
        //textView.setText(message);
    }
}
