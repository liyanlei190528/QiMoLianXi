package com.liyanlei.qimolianxi.presenter;

import com.liyanlei.qimolianxi.bean.HomeBean;
import com.liyanlei.qimolianxi.callback.HomeCallBack;
import com.liyanlei.qimolianxi.model.HomeModel;
import com.liyanlei.qimolianxi.view.HomeView;

public class HomePresenterImpl implements HomePresenter, HomeCallBack {

    private HomeModel homeModel;
    private HomeView homeView;

    public HomePresenterImpl(final HomeModel homeModel, final HomeView homeView) {
        this.homeModel = homeModel;
        this.homeView = homeView;
    }

    @Override
    public void getHomeDate(final String id) {
        if (homeModel != null){
            homeModel.getHomeDate(id,this);
        }
    }

    @Override
    public void onSuccess(final HomeBean homeBean) {
        if (homeView != null){
            homeView.onSuccess(homeBean);
        }
    }

    @Override
    public void onField(final String msg) {
        if (homeView != null){
            homeView.onField(msg);
        }
    }
}
