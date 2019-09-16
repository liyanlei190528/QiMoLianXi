package com.liyanlei.qimolianxi.callback;

import com.liyanlei.qimolianxi.bean.TabBean;

public interface TabCallBack {

    void onSuccess(TabBean tabBean);

    void onField(String msg);
}
