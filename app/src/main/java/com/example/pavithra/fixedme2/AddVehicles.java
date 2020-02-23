package com.example.pavithra.fixedme2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AddVehicles extends AppCompatActivity {
    public static String userId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vehicles);
        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        userId=message;
        // Capture the layout's TextView and set the string as its text
        //TextView textView = findViewById(R.id.txtWelcome);
        //textView.setText(message);
    }
    public void addedV(View view){
        Intent intent = new Intent(this, DriverMainAcc.class);
        //EditText editText = (EditText) findViewById(R.id.txtUserName);
        //String message = vehicleNo;
        //intent.putExtra(EXTRA_MESSAGE,message);
        startActivity(intent);
    }
}
