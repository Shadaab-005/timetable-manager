package com.example.timetablemanager;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class goalfragment extends Fragment {



    public goalfragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_goalfragment, container, false);
        List<goalstatus> datag=new ArrayList<>();
        datag.add(new goalstatus("hghg","vhghg","hgvhg"));
        datag.add(new goalstatus("hghg","vhghg","hgvhg"));
        datag.add(new goalstatus("hghg","vhghg","hgvhg"));
        datag.add(new goalstatus("hghg","vhghg","hgvhg"));
        datag.add(new goalstatus("hghg","vhghg","hgvhg"));
        datag.add(new goalstatus("hghg","vhghg","hgvhg"));
        RecyclerView recyclerView=view.findViewById(R.id.recyclerview3);
        RecyclerAdaptergoal recyclerAdaptergoal=new RecyclerAdaptergoal(datag,getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(recyclerAdaptergoal);
        return view;
    }
}