package com.example.pavithra.fixedme2;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DriverRegister extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.pavithra.fixedme2.MESSAGE";
    private FirebaseAuth mAuth;
    EditText txtEmail;
    EditText txtPassword;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference mRootReference = firebaseDatabase.getReference();
    public DatabaseReference mNewuser = mRootReference.child("users").child("drivers");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_register);
        mAuth = FirebaseAuth.getInstance();
    }
    public void signup(View view){
        //Intent intent = new Intent(this, MainActivity.class);
        //startActivity(intent);

        RegisterUser();
    }
    public void RegisterUser(){
        EditText txtEmail=(EditText)findViewById(R.id.txtEmail);
        EditText txtPassword=(EditText)findViewById(R.id.txtPassword);
        EditText txtUsername=(EditText)findViewById(R.id.txtUsername);
        EditText txtFname=(EditText)findViewById(R.id.txtName);
        EditText txtPhone=(EditText)findViewById(R.id.txtPhone);
        EditText txtAddress=(EditText)findViewById(R.id.txtAddress);


        //mNewuser.child("sakila").setValue("f");
        final String Email = txtEmail.getText().toString().trim();
        final String Password = txtPassword.getText().toString().trim();
        final String username = txtUsername.getText().toString().trim();

        final String fName = txtFname.getText().toString();
        final String phoneNum = txtPhone.getText().toString().trim();
        final String address = txtAddress.getText().toString();

        if (TextUtils.isEmpty(Email)){
            Toast.makeText(this, "A Field is Empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(Password)){
            Toast.makeText(this, "A Field is Empty", Toast.LENGTH_SHORT).show();
            return;
        }
        //mNewuser.child(Email).child("email").setValue(Email);
        mAuth.createUserWithEmailAndPassword(Email, Password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        try {
                            //check if successful
                            if (task.isSuccessful()) {
                                //User is successfully registered and logged in
                                //start Profile Activity here

                                Toast.makeText(DriverRegister.this, "registration successful",
                                        Toast.LENGTH_SHORT).show();
                                finish();
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            }else{
                                Toast.makeText(DriverRegister.this, "Couldn't register, try again",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                });

        mNewuser.child(username).child("email").setValue(Email);
        mNewuser.child(username).child("fullName").setValue(fName);
        mNewuser.child(username).child("phone").setValue(phoneNum);
        mNewuser.child(username).child("address").setValue(address);
    }

}
