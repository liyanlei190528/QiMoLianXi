package com.liyanlei.qimolianxi.presenter;

import com.liyanlei.qimolianxi.bean.TabBean;
import com.liyanlei.qimolianxi.callback.TabCallBack;
import com.liyanlei.qimolianxi.model.TabModel;
import com.liyanlei.qimolianxi.view.TabView;

public class TabPresenterImpl implements TabPresenter, TabCallBack {

    private TabModel tabModel;
    private TabView tabView;

    public TabPresenterImpl(final TabModel tabModel, final TabView tabView) {
        this.tabModel = tabModel;
        this.tabView = tabView;
    }

    @Override
    public void getTabDate() {
        if (tabModel != null){
            tabModel.getTabDate(this);
        }
    }

    @Override
    public void onSuccess(final TabBean tabBean) {
        if (tabView !=null){
            tabView.onSuccess(tabBean);
        }
    }

    @Override
    public void onField(final String msg) {
        if (tabView !=null){
            tabView.onField(msg);
        }
    }
}
