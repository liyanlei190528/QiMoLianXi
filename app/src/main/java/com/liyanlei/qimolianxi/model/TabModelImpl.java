package com.liyanlei.qimolianxi.model;

import com.liyanlei.qimolianxi.api.MyServer;
import com.liyanlei.qimolianxi.bean.TabBean;
import com.liyanlei.qimolianxi.callback.TabCallBack;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class TabModelImpl implements TabModel {
    @Override
    public void getTabDate(final TabCallBack callBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(MyServer.tabUrl)
                .build();
        MyServer myServer = retrofit.create(MyServer.class);
        Observable<TabBean> tabDate = myServer.getTabDate();
        tabDate.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TabBean>() {
                    @Override
                    public void onSubscribe(final Disposable d) {

                    }

                    @Override
                    public void onNext(final TabBean tabBean) {
                        if (callBack!=null){
                            callBack.onSuccess(tabBean);
                        }
                    }

                    @Override
                    public void onError(final Throwable e) {
                        if (callBack!=null){
                            callBack.onField(e.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
