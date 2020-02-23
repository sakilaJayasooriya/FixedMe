package com.example.pavithra.fixedme2;

import android.content.Intent;
import android.os.UserHandle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.pavithra.fixedme2.MESSAGE";
    public static boolean isDriver;
    private FirebaseAuth auth;

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference mRootReference = firebaseDatabase.getReference();
    private DatabaseReference mNewuser = mRootReference.child("users").child("drivers");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        isDriver=true;
        auth = FirebaseAuth.getInstance();
        if (auth.getCurrentUser() != null) {
            //startActivity(new Intent(MainActivity.this, DriverMainAcc.class));
            //finish();
        }

    }
    public void loginBoth(View view){
        final EditText txtuser=(EditText)findViewById(R.id.txtUserName);
        final EditText txtpwd=(EditText)findViewById(R.id.txtPassword);

        String email = txtuser.getText().toString();
        final String password = txtpwd.getText().toString();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
            return;
        }

        //progressBar.setVisibility(View.VISIBLE);

        //authenticate user
        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        //progressBar.setVisibility(View.GONE);
                        if (!task.isSuccessful()) {
                            // there was an error
                            if (password.length() < 6) {
                                txtpwd.setError(getString(R.string.minimum_password));
                            } else {
                                Toast.makeText(MainActivity.this, getString(R.string.auth_failed), Toast.LENGTH_LONG).show();
                            }
                        } else {
                            if(isDriver==true){
                                Intent intent = new Intent(MainActivity.this, DriverMainAcc.class);
                                //String message=auth.getCurrentUser().toString();
                                String message="welcome";
                                intent.putExtra(EXTRA_MESSAGE,message);
                                startActivity(intent);
                                finish();

                            }
                            else {
                                Intent intent = new Intent(MainActivity.this, GarageMainAcc.class);
                                //String message=auth.getCurrentUser().toString();
                                String message="welcome";
                                intent.putExtra(EXTRA_MESSAGE,message);
                                startActivity(intent);
                                finish();
                            }

                        }
                    }
                });

    }

    public void goRegisterPage(View view){
        Intent intent = new Intent(this, RegCommonActivity.class);
        startActivity(intent);

    }

    public void onRadioButtonClicked(View view){
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.rdDriver:
                if (checked)
                    isDriver=true;
                break;
            case R.id.rdGarage:
                if (checked)
                    isDriver=false;
                break;
        }

    }
}