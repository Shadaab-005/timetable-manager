package com.example.timetablemanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class register extends AppCompatActivity {

    public static final String TAG = "register";


    TextView alreadyhaveaccount;
    EditText inputemail,inputpassword,inputconfirmpassword,inputname;
    Button registerbtn;
    FirebaseFirestore fStore;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    String userID;

    ProgressDialog progressDialog;
    FirebaseAuth mAuth;
    FirebaseUser mUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        alreadyhaveaccount=findViewById(R.id.alreadyhaveaccount);

        inputname=findViewById(R.id.inputname);
        inputemail=findViewById(R.id.inputemail);
        inputpassword=findViewById(R.id.inputpassword);
        inputconfirmpassword=findViewById(R.id.inputconfirmpassword);
        registerbtn=findViewById(R.id.registerbtn);
        progressDialog= new ProgressDialog(this);
        mAuth=FirebaseAuth.getInstance();
        fStore=FirebaseFirestore.getInstance();
        mUser=mAuth.getCurrentUser();



        alreadyhaveaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(register.this,MainActivity.class));
            }
        });

        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                perforAuth();
            }
        });
    }

    private void perforAuth() {
        String email=inputemail.getText().toString();
        String password=inputpassword.getText().toString();
        String fullname=inputname.getText().toString();
        String confirmpassword=inputconfirmpassword.getText().toString();

        if (!email.matches(emailPattern))
        {
            inputemail.setError("Enter correct Email");
        }else if (password.isEmpty() || password.length()<6)
        {
            inputpassword.setError("Enter proper password");
        }else if (!password.equals(confirmpassword))
        {
            inputconfirmpassword.setError("Passwowd not matched");
        }else
        {
            progressDialog.setMessage("Please Wait While Registration....");
            progressDialog.setTitle("Registration");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (task.isSuccessful())
                    {
                        progressDialog.dismiss();
                        sendUserToNextActivity();
                        Toast.makeText(register.this,"Registration Successful", Toast.LENGTH_SHORT).show();
                        userID=mAuth.getCurrentUser().getUid();
                        DocumentReference documentReference=fStore.collection("Users").document();
                        Map<String,Object> user= new HashMap<>();
                        user.put("fName",fullname);
                        user.put("email",email);
                        documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Log.d(TAG, "onSuccess: user profile is created for "+ user);
                            }
                        });



                    }else
                    {
                        progressDialog.dismiss();
                        Toast.makeText(register.this, ""+task.getException(), Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }


    }

    private void sendUserToNextActivity() {
        Intent intent=new Intent(register.this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}