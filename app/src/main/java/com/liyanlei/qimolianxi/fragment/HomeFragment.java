package com.liyanlei.qimolianxi.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.liyanlei.qimolianxi.R;
import com.liyanlei.qimolianxi.adapter.HomeAdapter;
import com.liyanlei.qimolianxi.bean.HomeBean;
import com.liyanlei.qimolianxi.model.HomeModelImpl;
import com.liyanlei.qimolianxi.presenter.HomePresenterImpl;
import com.liyanlei.qimolianxi.view.HomeView;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements HomeView {

    private View view;
    private ImageView mImg;
    /**
     * title
     */
    private TextView mTitle;
    /**
     * name
     */
    private TextView mName;
    private RecyclerView mRv;
    private ArrayList<HomeBean.DataBean.CurrentCategoryBean.SubCategoryListBean> list;
    private HomeAdapter homeAdapter;
    private String id;
    private HomePresenterImpl homePresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_home, container, false);
        initView(inflate);
        initDate();
        return inflate;
    }

    private void initDate() {
        homePresenter = new HomePresenterImpl(new HomeModelImpl(), this);
        homePresenter.getHomeDate(id);
    }

    private void initView(View inflate) {
        mImg = (ImageView) inflate.findViewById(R.id.img);
        mTitle = (TextView) inflate.findViewById(R.id.title);
        mName = (TextView) inflate.findViewById(R.id.name);
        mRv = (RecyclerView) inflate.findViewById(R.id.rv);

        Bundle bundle = getArguments();
        id = bundle.getString("id");


        list = new ArrayList<>();

        homeAdapter = new HomeAdapter(getActivity(), list);

        mRv.setAdapter(homeAdapter);
        mRv.setLayoutManager(new GridLayoutManager(getActivity(),3));
    }

    @Override
    public void onSuccess(final HomeBean homeBean) {
        list.addAll(homeBean.getData().getCurrentCategory().getSubCategoryList());

        HomeBean.DataBean.CurrentCategoryBean currentCategory = homeBean.getData().getCurrentCategory();
        Glide.with(getActivity()).load(currentCategory.getBanner_url()).into(mImg);
        mTitle.setText(currentCategory.getFront_name());
        mName.setText("--"+currentCategory.getName()+"分类"+"--");

        homeAdapter.notifyDataSetChanged();
    }

    @Override
    public void onField(final String msg) {
        Toast.makeText(getActivity(), ""+msg, Toast.LENGTH_SHORT).show();
    }
}
