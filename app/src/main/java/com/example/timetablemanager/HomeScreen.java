package com.example.timetablemanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class HomeScreen extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Viewpageradapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        tabLayout= findViewById(R.id.tablayout);
        viewPager= findViewById(R.id.viewpager);
        adapter= new Viewpageradapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);
        adapter.AddFragment(new fragment_futuretasks(),"Future Tasks");
        adapter.AddFragment(new fragment_postponed(),"Postponed Tasks");
        adapter.AddFragment(new fragment_goalstatus(),"Goal Status");
        viewPager.setAdapter(adapter);
    }
}