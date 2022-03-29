package com.example.timetablemanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class forgotpassword extends AppCompatActivity {

    private Button resetbtn;
    private EditText txtemail;
    private String email;
    private FirebaseAuth auth;

    TextView backtologin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);
        backtologin=findViewById(R.id.backtologin);

        auth= FirebaseAuth.getInstance();

        txtemail= findViewById(R.id.emailid);
        resetbtn= findViewById(R.id.resetbtn);

        resetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateData();
            }
        });

        backtologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(forgotpassword.this,MainActivity.class));
            }
        });
    }

    private void validateData() {
        email= txtemail.getText().toString();
        if (email.isEmpty()){
            txtemail.setError("Required");
        }else{
            forgetpass();
        }
    }

    private void forgetpass() {
        auth.sendPasswordResetEmail(email).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(forgotpassword.this, "Reset link sent to your email",Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(forgotpassword.this, "Error! Reset link not sent to your email"+e.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}