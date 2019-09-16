package com.liyanlei.qimolianxi.view;

import com.liyanlei.qimolianxi.bean.HomeBean;

public interface HomeView {

    void onSuccess(HomeBean homeBean);

    void onField(String msg);
}
