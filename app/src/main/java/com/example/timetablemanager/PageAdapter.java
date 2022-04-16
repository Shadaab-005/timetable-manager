package com.example.timetablemanager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PageAdapter extends FragmentPagerAdapter {
    private int numberoftab;
    public PageAdapter(@NonNull FragmentManager fm,int numberoftab) {

        super(fm);
        this.numberoftab=numberoftab;
    }

    @NonNull
    @Override
    public Fragment getItem(int i) {

        switch (i) {
            case 0:
                return new futurefragment();
            case 1:
                return new postponedfragment();
            case 2:
                return new goalfragment();
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return numberoftab;
    }
}
