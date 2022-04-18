package com.example.timetablemanager;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.timetablemanager.myroomdatabase.MyRoomDatabase;
import com.example.timetablemanager.myroomdatabase.ToDoTaskTable;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.

 * create an instance of this fragment.
 */
public class futurefragment extends Fragment{

    private Button addNewTask;
    ToDoTaskRecyclerAdapter toDoTaskRecyclerAdapter;
    private RecyclerView recyclerView;
    public List<ToDoTaskTable> toDoModelList = new ArrayList<>();
    private MyRoomDatabase myRoomDatabase;
    private CoordinatorLayout coordinatorLayout;
    public  FloatingActionButton floatingActionButton;




    public futurefragment() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {






        // Inflate the layout for this fragment

        View view= inflater.inflate(R.layout.fragment_futurefragment, container, false);
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        FloatingActionButton floatingActionButton= view.findViewById(R.id.btnfloating);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startActivityForResult(new Intent(getActivity(),Add_itemActivity.class),100);
            }
        });
        myRoomDatabase= MyRoomDatabase.getInstance(getContext());

        RecyclerView recyclerView=view.findViewById(R.id.recyclervw1);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        collectItems();








        return view;}
    private void collectItems(){
        toDoModelList=myRoomDatabase.myDaoInterface().collectList();
        RecyclerView.Adapter adapter= new ToDoTaskRecyclerAdapter(futurefragment.this,toDoModelList,myRoomDatabase);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }










    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 100) {

        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}