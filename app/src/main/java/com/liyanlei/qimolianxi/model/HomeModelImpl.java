package com.liyanlei.qimolianxi.model;

import com.liyanlei.qimolianxi.api.MyServer;
import com.liyanlei.qimolianxi.bean.HomeBean;
import com.liyanlei.qimolianxi.callback.HomeCallBack;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeModelImpl implements HomeModel {
    @Override
    public void getHomeDate(final String id, final HomeCallBack callBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(MyServer.homeUrl)
                .build();
        MyServer myServer = retrofit.create(MyServer.class);
        Observable<HomeBean> homeDate = myServer.getHomeDate(id);
        homeDate.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomeBean>() {
                    @Override
                    public void onSubscribe(final Disposable d) {

                    }

                    @Override
                    public void onNext(final HomeBean homeBean) {

                        if (callBack !=null){
                            callBack.onSuccess(homeBean);
                        }
                    }

                    @Override
                    public void onError(final Throwable e) {
                        if (callBack !=null){
                            callBack.onField(e.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
