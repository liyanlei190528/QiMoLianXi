package com.liyanlei.qimolianxi.callback;

import com.liyanlei.qimolianxi.bean.HomeBean;

public interface HomeCallBack {

    void onSuccess(HomeBean homeBean);

    void onField(String msg);
}
