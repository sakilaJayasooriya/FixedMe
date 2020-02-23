package com.example.pavithra.fixedme2;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;


public class DriverMainAcc extends AppCompatActivity {
    private FirebaseAuth.AuthStateListener authListener;
    private FirebaseAuth auth;

    public static final String EXTRA_MESSAGE = "com.example.pavithra.fixedme2.MESSAGE";

    public static String userId=" ";
    public static String vehicleNo="US2465";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_main_acc);
        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.txtWelcome);


        //get firebase auth instance
        auth = FirebaseAuth.getInstance();

        //get current user
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String email ="welcome";
        email = user.getEmail();
        String welcome="Welcome: ".concat(email);
        textView.setText(welcome);

        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                //email = user.getEmail();
                //userId=message.concat(email);
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {
                    // user auth state is changed - user is null
                    // launch login activity
                    startActivity(new Intent(DriverMainAcc.this, MainActivity.class));
                    finish();
                }
            }
        };


    }
    public void logout(View view){
        auth.signOut();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void goAddVehicle(View view){
        Intent intent = new Intent(this, AddVehicles.class);
        //EditText editText = (EditText) findViewById(R.id.txtUserName);
        String message = userId;
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivity(intent);
    }
    public void goAddRepair(View view){
        Intent intent = new Intent(this, AddRepair.class);
        //EditText editText = (EditText) findViewById(R.id.txtUserName);
        String message = vehicleNo;
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivity(intent);
    }
    public void goViewRepairs(View view){
        Intent intent = new Intent(this, MyRepairs.class);
        //EditText editText = (EditText) findViewById(R.id.txtUserName);
        String message = vehicleNo;
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivity(intent);
    }
    public void helpMe(View view){
        Intent intent = new Intent(this, DriverMainAcc.class);
        //EditText editText = (EditText) findViewById(R.id.txtUserName);
        String message = vehicleNo;
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivity(intent);
    }

}
