package com.liyanlei.qimolianxi.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.liyanlei.qimolianxi.bean.TabBean;

import java.util.ArrayList;

public class TabAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragments;
    private ArrayList<TabBean.DataBean.CategoryListBean> list;

    public TabAdapter(final FragmentManager fm) {
        super(fm);
    }

    public TabAdapter(final FragmentManager childFragmentManager, final ArrayList<Fragment> fragments, final ArrayList<TabBean.DataBean.CategoryListBean> list) {
        super(childFragmentManager);
        this.fragments = fragments;
        this.list = list;
    }

    @Override
    public Fragment getItem(final int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(final int position) {
        return list.get(position).getName();
    }
}
