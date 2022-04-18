package com.example.timetablemanager;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.graphics.Paint;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.timetablemanager.myroomdatabase.MyRoomDatabase;
import com.example.timetablemanager.myroomdatabase.ToDoTaskTable;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class ToDoTaskRecyclerAdapter extends RecyclerView.Adapter<ToDoTaskRecyclerAdapter.MyViewHolder> {


    Context context;
    List<ToDoTaskTable> toDoTaskTableList;
    MyRoomDatabase myRoomDatabase;
    AlertDialog alertDialog;
    public ToDoTaskRecyclerAdapter(futurefragment futurefragment, List<ToDoTaskTable> toDoModelList, MyRoomDatabase myRoomDatabase) {

        this.toDoTaskTableList =toDoModelList;
        this.myRoomDatabase= myRoomDatabase;
        this.context= context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recy_design,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        final ToDoTaskTable toDoModel = toDoTaskTableList.get(position);
        holder.todoItem.setText(toDoModel.getTask());
        final SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        final SimpleDateFormat hFormat= new SimpleDateFormat("K:mm a", Locale.ENGLISH);
        final String strDate= dateFormat.format(toDoModel.getDate());
        holder.todoDate.setText(strDate);
        String event_Time= hFormat.format(toDoModel.getTime());
        holder.todoTime.setText(event_Time);
        holder.delete.setOnClickListener((view) -> {
            myRoomDatabase.myDaoInterface().delete(toDoModel);
            toDoTaskTableList= myRoomDatabase.myDaoInterface().collectList();
            notifyDataSetChanged();
        });

        holder.complete.setChecked(toDoModel.getCompleted());

        if (toDoModel.getCompleted()){
            holder.todoItem.setPaintFlags(holder.todoItem.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }else{
            holder.todoItem.setPaintFlags(0);
        }

        holder.setItemClickListner(new MyOnClickListner() {
            @Override
            public void onClickListner(View view, int itemPosition) {
                CheckBox checkBox=(CheckBox)view;
                if (checkBox.isChecked()){
                    toDoModel.setCompleted(true);

                }else{
                    toDoModel.setCompleted(false);
                }

                myRoomDatabase.myDaoInterface().update(toDoModel);
                myRoomDatabase.myDaoInterface().collectList();
                notifyDataSetChanged();

            }
        });

        holder.edit.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder= new AlertDialog.Builder(context);
                builder.setCancelable(true);
                View nView= LayoutInflater.from(context).inflate(R.layout.updateitem_layout,null);
                final EditText taskname= nView.findViewById(R.id.textview1);
                taskname.setText(toDoModel.getTask());
                final TextView todoDate= nView.findViewById(R.id.textview2);
                todoDate.setText(dateFormat.format(toDoModel.getDate()));
                final TextView todoTime= nView.findViewById(R.id.textview3);
                todoTime.setText(hFormat.format(toDoModel.getTime()));
                final EditText taskdesc= nView.findViewById(R.id.textview4);
                taskname.setText(toDoModel.getDesc());
                Button setToDoDate =nView.findViewById(R.id.datebtn);
                setToDoDate.setOnClickListener(view1 -> {
                    java.util.Calendar calendar= java.util.Calendar.getInstance();
                    int year = calendar.get(java.util.Calendar.YEAR);
                    int month = calendar.get(java.util.Calendar.MONTH);
                    int day = calendar.get(java.util.Calendar.DAY_OF_MONTH);
                    DatePickerDialog datePickerDialog;
                    datePickerDialog= new DatePickerDialog(context, (view2, year1, month1, dayOfMonth) -> {
                        final java.util.Calendar c= java.util.Calendar.getInstance(Locale.ENGLISH);
                        c.set(java.util.Calendar.YEAR, year1);
                        c.set(Calendar.MONTH, month1);
                        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        final String strDate= dateFormat.format(c.getTime());
                        todoDate.setText(strDate);
                        toDoModel.setDate(c.getTime());


                    },year,month,day);
                    datePickerDialog.show();
                });

                Button setToDoTime = nView.findViewById(R.id.timebtn);
                setToDoTime.setOnClickListener(view1 -> {
                    Calendar calendar = Calendar.getInstance();
                    int hours= calendar.get(Calendar.HOUR_OF_DAY);
                    int minuts= calendar.get(Calendar.MINUTE);
                    TimePickerDialog timePickerDialog= new TimePickerDialog(context, androidx.appcompat.R.style.Theme_AppCompat_Dialog, (view2,hourOfDay, minute) ->{
                        Calendar c =Calendar.getInstance();
                        c.set(Calendar.HOUR_OF_DAY,hourOfDay);
                        c.set(Calendar.MINUTE,minute);
                        c.setTimeZone(TimeZone.getDefault());
                        SimpleDateFormat hformate= new SimpleDateFormat("K:mm a",Locale.ENGLISH);
                        String event_Time= hformate.format(c.getTime());
                        todoTime.setText(event_Time);
                        toDoModel.setTime(c.getTime());


                    },hours,minuts,false);
                    timePickerDialog.show();
                });

                Button updateItem= nView.findViewById(R.id.btnupdatetask);
                updateItem.setOnClickListener(view1 -> {
                    if(toDoModel.getDate() == null){
                        Toast.makeText(context,"Select Date",Toast.LENGTH_SHORT).show();
                    }else if(toDoModel.getTime()== null){
                        Toast.makeText(context,"Select Time",Toast.LENGTH_SHORT).show();
                    }else {
                        String task = taskname.getText().toString();
                        if (TextUtils.isEmpty(task)){
                            Toast.makeText(context,"Insert Task Name",Toast.LENGTH_SHORT).show();
                        }else{
                            toDoModel.setTask(task);
                            myRoomDatabase.myDaoInterface().update(toDoModel);
                            myRoomDatabase.myDaoInterface().collectList();
                            notifyDataSetChanged();
                            alertDialog.dismiss();
                        }
                    }
                });

                builder.setView(nView);
                alertDialog = builder.create();
                alertDialog.show();
            }
        });

    }



    @Override
    public int getItemCount() {
        return toDoTaskTableList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView todoItem,todoItemdesc,todoDate,todoTime;
        Button edit,delete;
        CheckBox complete;
        private MyOnClickListner myOnClickListner;



        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            todoItem=itemView.findViewById(R.id.textview1);
            todoDate=itemView.findViewById(R.id.textview2);
            todoTime=itemView.findViewById(R.id.textview3);
            todoItemdesc=itemView.findViewById(R.id.textview4);
            delete= itemView.findViewById(R.id.Delete);
            edit= itemView.findViewById(R.id.Edit);
            complete= itemView.findViewById(R.id.completecb);
            complete.setOnClickListener(this);
        }
        void setItemClickListner(MyOnClickListner myOnClickListner){
            this.myOnClickListner= myOnClickListner;

        }

        @Override
        public void onClick(View view) {

            this.myOnClickListner.onClickListner(view,getLayoutPosition());

        }
    }
}
