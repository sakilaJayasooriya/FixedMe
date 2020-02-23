package com.example.pavithra.fixedme2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class RegCommonActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.pavithra.fixedme2.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_common);
    }
    public void goDriverRegPage(View view){
        Intent intent = new Intent(this, DriverRegister.class);
        startActivity(intent);
    }
    public void goGarageRegPage(View view){
        Intent intent = new Intent(this, GarageRegister.class);
        startActivity(intent);
    }
}
