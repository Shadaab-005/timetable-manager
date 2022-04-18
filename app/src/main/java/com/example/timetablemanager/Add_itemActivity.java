package com.example.timetablemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.timetablemanager.myroomdatabase.MyRoomDatabase;
import com.example.timetablemanager.myroomdatabase.ToDoTaskTable;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class Add_itemActivity extends AppCompatActivity {

    private EditText taskName;
    private EditText taskdesc;
    private TextView toDoDate, toDoTime;
    private Button btnaddtask;
    private MyRoomDatabase myRoomDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        taskName = findViewById(R.id.tasktitle);
        taskdesc = findViewById(R.id.taskdescription);
        toDoDate = findViewById(R.id.taskdate);
        toDoTime = findViewById(R.id.tasktime);

        btnaddtask = findViewById(R.id.btnaddtask);
        myRoomDatabase = MyRoomDatabase.getInstance(getApplicationContext());

        final ToDoTaskTable toDoTable = new ToDoTaskTable();

        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        final SimpleDateFormat hFormat = new SimpleDateFormat("K:mm a", Locale.ENGLISH);

        Button setToDoDate = findViewById(R.id.datebtn);
        setToDoDate.setOnClickListener(view1 -> {
            java.util.Calendar calendar = java.util.Calendar.getInstance();
            int year = calendar.get(java.util.Calendar.YEAR);
            int month = calendar.get(java.util.Calendar.MONTH);
            int day = calendar.get(java.util.Calendar.DAY_OF_MONTH);
            DatePickerDialog datePickerDialog;
            datePickerDialog = new DatePickerDialog(Add_itemActivity.this, (view2, year1, month1, dayOfMonth) -> {
                final java.util.Calendar c = java.util.Calendar.getInstance(Locale.ENGLISH);
                c.set(java.util.Calendar.YEAR, year1);
                c.set(Calendar.MONTH, month1);
                c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                final String strDate = dateFormat.format(c.getTime());
                toDoDate.setText(strDate);
                toDoTable.setDate(c.getTime());


            }, year, month, day);
            datePickerDialog.show();
        });

        Button setToDoTime = findViewById(R.id.timebtn);
        setToDoTime.setOnClickListener(view1 -> {
            Calendar calendar = Calendar.getInstance();
            int hours = calendar.get(Calendar.HOUR_OF_DAY);
            int minuts = calendar.get(Calendar.MINUTE);
            TimePickerDialog timePickerDialog = new TimePickerDialog(Add_itemActivity.this, androidx.appcompat.R.style.Theme_AppCompat_Dialog, (view2, hourOfDay, minute) -> {
                Calendar c = Calendar.getInstance();
                c.set(Calendar.HOUR_OF_DAY, hourOfDay);
                c.set(Calendar.MINUTE, minute);
                c.setTimeZone(TimeZone.getDefault());
                SimpleDateFormat hformate = new SimpleDateFormat("K:mm a", Locale.ENGLISH);
                String event_Time = hformate.format(c.getTime());
                toDoTime.setText(event_Time);
                toDoTable.setTime(c.getTime());


            }, hours, minuts, false);
            timePickerDialog.show();
        });


        btnaddtask.setOnClickListener(view1 -> {
            if (toDoTable.getDate() == null) {
                Toast.makeText(Add_itemActivity.this, "Select Date", Toast.LENGTH_SHORT).show();
            } else if (toDoTable.getTime() == null) {
                Toast.makeText(Add_itemActivity.this, "Select Time", Toast.LENGTH_SHORT).show();
            } else {
                String task = taskName.getText().toString();
                if (TextUtils.isEmpty(task)) {
                    Toast.makeText(Add_itemActivity.this, "Insert Task Name", Toast.LENGTH_SHORT).show();
                } else {
                    toDoTable.setTask(task);
                    toDoTable.setCompleted(false);
                    myRoomDatabase.myDaoInterface().insert(toDoTable);
                    Toast.makeText(Add_itemActivity.this, "Task has been added successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Add_itemActivity.this, futurefragment.class));
                    finish();
                }


            }
        });
    }
}