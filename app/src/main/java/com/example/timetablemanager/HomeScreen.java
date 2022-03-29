package com.example.timetablemanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class HomeScreen extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        tabLayout= findViewById(R.id.tablayout);
        viewPager= findViewById(R.id.viewpager);

        tabLayout.setupWithViewPager(viewPager);
        VPadapter vPadapter = new VPadapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vPadapter.addFragment(new fragment1(),"Future Tasks");
        vPadapter.addFragment(new fragment2(),"Postponed Tasks");
        vPadapter.addFragment(new fragment3(),"Goal Status");
        viewPager.setAdapter(vPadapter);
    }
}