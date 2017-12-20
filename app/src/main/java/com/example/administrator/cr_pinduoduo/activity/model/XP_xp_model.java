package com.example.administrator.cr_pinduoduo.activity.model;

import com.example.administrator.cr_pinduoduo.activity.bean.Xp_xpbean;
import com.example.administrator.cr_pinduoduo.activity.getquest_In.Xp_xp_getrequest;

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

public class XP_xp_model implements XP_xp_Imodel {
    private Xp_xpbean xp_xpbean;
    private int goods_id;


    @Override
    public void shuju(Observer<Xp_xpbean> observer, final int goods_id) {
        //创建被观察者
        Observable.create(new Observable.OnSubscribe<Xp_xpbean>() {
            @Override
            public void call(final Subscriber<? super Xp_xpbean> subscriber) {
                //Retrofit的请求数据
                Retrofit retrofit=new Retrofit.Builder()
                        //设置网络请求的url
                        .baseUrl("http://apiv4.yangkeduo.com/v5/goods/")
                        //设置Gson
                        .addConverterFactory(GsonConverterFactory.create())
                        //设置Rxjava
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                        .build();

                //创建网络请求接口的实例
                Xp_xp_getrequest Request=retrofit.create(Xp_xp_getrequest.class);
                //对发的请求进行封装
                Call<Xp_xpbean> call=Request.getCall(goods_id);
                //使用异步发送网络请求
                call.enqueue(new Callback<Xp_xpbean>(){
                    //请求成功时回调
                    @Override
                    public void onResponse(Call<Xp_xpbean> call, Response<Xp_xpbean> response) {
                        xp_xpbean=response.body();
                        //调用OnNext方法把值传给观察者
                        subscriber.onNext(xp_xpbean);
                        subscriber.onCompleted();
                    }

                    //请求失败时的回调
                    @Override
                    public void onFailure(Call<Xp_xpbean> call, Throwable t) {

                    }
                });

            }
        }).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

    }
}
