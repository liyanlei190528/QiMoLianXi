package com.liyanlei.qimolianxi.view;

import com.liyanlei.qimolianxi.bean.TabBean;

public interface TabView {
    void onSuccess(TabBean tabBean);

    void onField(String msg);
}
