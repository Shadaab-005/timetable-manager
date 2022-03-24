package com.example.timetablemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class register extends AppCompatActivity {

    TextView alreadyhaveaccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        alreadyhaveaccount=findViewById(R.id.alreadyhaveaccount);


        alreadyhaveaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(register.this,MainActivity.class));
            }
        });
    }
}