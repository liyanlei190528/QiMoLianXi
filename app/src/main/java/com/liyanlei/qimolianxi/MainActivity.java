package com.liyanlei.qimolianxi;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.liyanlei.qimolianxi.adapter.FragmentAdapter;
import com.liyanlei.qimolianxi.fragment.AFragment;
import com.liyanlei.qimolianxi.fragment.BFragment;
import com.liyanlei.qimolianxi.fragment.CFragment;
import com.liyanlei.qimolianxi.fragment.DFragment;
import com.liyanlei.qimolianxi.fragment.EFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTab;
    private ViewPager mVp;
    private ArrayList<Fragment> fragments;
    private FragmentAdapter fragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTab = (TabLayout) findViewById(R.id.tab);
        mVp = (ViewPager) findViewById(R.id.vp);

        fragments = new ArrayList<>();
        fragments.add(new AFragment());
        fragments.add(new BFragment());
        fragments.add(new CFragment());
        fragments.add(new DFragment());
        fragments.add(new EFragment());

        fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), fragments);
        mVp.setAdapter(fragmentAdapter);
        mTab.setupWithViewPager(mVp);

        mTab.getTabAt(0).setCustomView(R.layout.fma);
        mTab.getTabAt(1).setCustomView(R.layout.fmb);
        mTab.getTabAt(2).setCustomView(R.layout.fmc);
        mTab.getTabAt(3).setCustomView(R.layout.fmd);
        mTab.getTabAt(4).setCustomView(R.layout.fme);
    }
}
