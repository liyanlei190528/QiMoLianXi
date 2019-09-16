package com.liyanlei.qimolianxi.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class FragmentAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragments;

    public FragmentAdapter(final FragmentManager fm) {
        super(fm);
    }

    public FragmentAdapter(final FragmentManager supportFragmentManager, final ArrayList<Fragment> fragments) {
        super(supportFragmentManager);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(final int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
