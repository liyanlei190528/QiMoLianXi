package com.liyanlei.qimolianxi.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.liyanlei.qimolianxi.R;
import com.liyanlei.qimolianxi.adapter.TabAdapter;
import com.liyanlei.qimolianxi.bean.TabBean;
import com.liyanlei.qimolianxi.model.TabModelImpl;
import com.liyanlei.qimolianxi.presenter.TabPresenterImpl;
import com.liyanlei.qimolianxi.view.TabView;

import java.util.ArrayList;
import java.util.List;

public class CFragment extends Fragment implements TabView {

    private View view;
    private TabLayout mTab;
    private ViewPager mVp;
    private ArrayList<TabBean.DataBean.CategoryListBean> list;
    private ArrayList<Fragment> fragments;
    private TabAdapter tabAdapter;
    private TabPresenterImpl tabPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_c, container, false);
        initView(inflate);
        initDate();
        return inflate;
    }

    private void initDate() {
        tabPresenter = new TabPresenterImpl(new TabModelImpl(), this);
        tabPresenter.getTabDate();
    }

    private void initView(View inflate) {
        mTab = (TabLayout) inflate.findViewById(R.id.tab);
        mVp = (ViewPager) inflate.findViewById(R.id.vp);

        list = new ArrayList<>();

        fragments = new ArrayList<>();

        tabAdapter = new TabAdapter(getChildFragmentManager(), fragments, list);

        mVp.setAdapter(tabAdapter);

        mTab.setupWithViewPager(mVp);
    }

    @Override
    public void onSuccess(final TabBean tabBean) {
        List<TabBean.DataBean.CategoryListBean> categoryList = tabBean.getData().getCategoryList();

        for (int i = 0; i <categoryList.size() ; i++) {
            list.addAll(categoryList);

            HomeFragment homeFragment = new HomeFragment();

            Bundle bundle = new Bundle();
            bundle.putString("id",categoryList.get(i).getId()+"");
            homeFragment.setArguments(bundle);
            fragments.add(homeFragment);
        }
        tabAdapter.notifyDataSetChanged();
    }

    @Override
    public void onField(final String msg) {
        Toast.makeText(getActivity(), ""+msg, Toast.LENGTH_SHORT).show();
    }
}
