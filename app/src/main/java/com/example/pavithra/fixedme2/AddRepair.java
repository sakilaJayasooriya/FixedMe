package com.example.pavithra.fixedme2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AddRepair extends AppCompatActivity {
    public static String vehicleNo=" ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_repair);
        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        vehicleNo=message;
        String headtxt="Vehicle No:".concat(vehicleNo);
        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.txtVehicleNo);
        textView.setText(headtxt);
    }
    public void added(View view){
        Intent intent = new Intent(this, DriverMainAcc.class);
        //EditText editText = (EditText) findViewById(R.id.txtUserName);
        //String message = vehicleNo;
        //intent.putExtra(EXTRA_MESSAGE,message);
        startActivity(intent);
    }
}
