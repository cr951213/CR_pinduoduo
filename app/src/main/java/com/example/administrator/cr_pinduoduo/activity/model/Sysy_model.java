package com.example.administrator.cr_pinduoduo.activity.model;

import com.example.administrator.cr_pinduoduo.activity.bean.SysyBean;
import com.example.administrator.cr_pinduoduo.activity.getquest_In.Sysy_getrequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/12/13.
 */

public class Sysy_model implements Sysy_Imodel {

    private SysyBean sysyBean;

    @Override
    public void shuju(Observer<SysyBean> observer) {
        //创建被观察者
        Observable.create(new Observable.OnSubscribe<SysyBean>() {
            @Override
            public void call(final Subscriber<? super SysyBean> subscriber) {
                //Retrofit的请求数据
                Retrofit retrofit=new Retrofit.Builder()
                        //设置网络请求的url
                        .baseUrl("https://www.zhaoapi.cn/ad/")
                        //设置Gson
                        .addConverterFactory(GsonConverterFactory.create())
                        //设置Rxjava
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                        .build();

                //创建网络请求接口的实例
                Sysy_getrequest Request=retrofit.create(Sysy_getrequest.class);
                //对发的请求进行封装
                Call<SysyBean> call=Request.getCall();
                //使用异步发送网络请求
                call.enqueue(new Callback<SysyBean>(){
                    //请求成功时回调
                    @Override
                    public void onResponse(Call<SysyBean> call, Response<SysyBean> response) {
                        sysyBean=response.body();
                        //调用OnNext方法把值传给观察者
                        subscriber.onNext(sysyBean);

                        subscriber.onCompleted();
                    }

                    //请求失败时的回调
                    @Override
                    public void onFailure(Call<SysyBean> call, Throwable t) {

                    }
                });

            }
        }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);




    }
}
