package com.example.timetablemanager;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.

 * create an instance of this fragment.
 */
public class futurefragment extends Fragment {



    public futurefragment() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_futurefragment, container, false);
        FloatingActionButton floatingActionButton= view.findViewById(R.id.btnfloating);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog=new Dialog(getContext());
                dialog.setContentView(R.layout.add_task);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                Button btn=dialog.findViewById(R.id.btnaddtask);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getContext(),"Task Added",Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
                dialog.show();

            }
        });




        List<futuretasks> data=new ArrayList<>();
        data.add(new futuretasks("hghg","vhghg","hgvhg"));
        data.add(new futuretasks("hghg","vhghg","hgvhg"));
        data.add(new futuretasks("hghg","vhghg","hgvhg"));
        data.add(new futuretasks("hghg","vhghg","hgvhg"));
        RecyclerView recyclerView=view.findViewById(R.id.recyclervw1);
        RecyclerAdapter recyclerAdapter=new RecyclerAdapter(data,getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(recyclerAdapter);
        return view;
    }
}