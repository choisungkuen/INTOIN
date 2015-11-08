package com.example.intoin.myapplication.viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.intoin.myapplication.R;


public class DemoPagerAdapter extends FragmentPagerAdapter {

    private int pagerCount = 4;


    public DemoPagerAdapter(FragmentManager fm) {
        super(fm);

    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return GuideFragment_1.newInstance(R.layout.guide1_fragment);
            case 1:
                return GuideFragment_2.newInstance(R.layout.guide2_fragment);
            case 2:
                return GuideFragment_3.newInstance(R.layout.guide3_fragment);
            case 3:
                return GuideFragment_4.newInstance(R.layout.guide4_fragment);
            default:
                return new Fragment();
        }

    }


    @Override
    public int getCount() {
        return pagerCount;
    }
}