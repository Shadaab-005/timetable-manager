package com.example.timetablemanager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class fragment_futuretasks extends Fragment {

    View v;
    private RecyclerView myrecyclerview;
    private List<futuretasks>fragmentArrayList;

    public fragment_futuretasks() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.future_fragment,container,false);
        myrecyclerview=(RecyclerView) v.findViewById(R.id.future_recyclerview);
        Recyclerviewadapter recyclerAdapter= new Recyclerviewadapter(getContext(),fragmentArrayList);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerview.setAdapter(recyclerAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fragmentArrayList= new ArrayList<>();
        fragmentArrayList.add(new futuretasks("Drink Water","6:45 AM","Drinking water is necessary for our body"));
        fragmentArrayList.add(new futuretasks("Go For a Walk","7:00 AM","Walking daily makes us fit"));
        fragmentArrayList.add(new futuretasks("Go to School","7:45 AM","To study all subjects"));
        fragmentArrayList.add(new futuretasks("Play Football","9:45 AM","Playing outdoor games"));
        fragmentArrayList.add(new futuretasks("Talk to the Class Teacher","10;45 AM","For Leave application"));
        fragmentArrayList.add(new futuretasks("Go to Shopping","3:15 PM","Buy a pair of shoes"));
        fragmentArrayList.add(new futuretasks("Come back hostel","9:45 PM","Return to hostel"));

    }
}
