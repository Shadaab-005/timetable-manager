package com.example.timetablemanager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class Viewpageradapter extends FragmentPagerAdapter {

    private final ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    private final ArrayList<Fragment> fragmentArrayList1 = new ArrayList<>();
    private final ArrayList<String> fragmentTitle = new ArrayList<>();
    private final ArrayList<String> fragmentTitle1 = new ArrayList<>();

    public Viewpageradapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentArrayList.get(position);
    }


    @Override
    public int getCount() {
        return fragmentTitle.size();
    }



    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentTitle.get(position);
    }


public void AddFragment (Fragment fragment,String title){
    fragmentArrayList.add(fragment);
    fragmentTitle.add(title);
}



}



