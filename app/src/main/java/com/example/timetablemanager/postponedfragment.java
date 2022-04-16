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
public class postponedfragment extends Fragment {


    public postponedfragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_postponedfragment, container, false);
        List<postponedtasks> datas=new ArrayList<>();
        datas.add(new postponedtasks("hghg","vhghg","hgvhg"));
        datas.add(new postponedtasks("hghg","vhghg","hgvhg"));
        datas.add(new postponedtasks("hghg","vhghg","hgvhg"));
        datas.add(new postponedtasks("hghg","vhghg","hgvhg"));
        datas.add(new postponedtasks("hghg","vhghg","hgvhg"));
        RecyclerView recyclerView=view.findViewById(R.id.recyclerview2);
        RecyclerAdapterpostponed recyclerAdapterpostponed=new RecyclerAdapterpostponed(datas,getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(recyclerAdapterpostponed);
        return view;
    }
}