package com.example.administrator.cr_pinduoduo.activity.model;

import com.example.administrator.cr_pinduoduo.activity.bean.Sppjbean;
import com.example.administrator.cr_pinduoduo.activity.getquest_In.Xp_pj_getrequest;

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

public class XP_pj_model implements XP_pj_Imodel {
    private Sppjbean sppjbean;
    private int uid;


    @Override
    public void shuju(Observer<Sppjbean> observer, final int uid) {
        //创建被观察者
        Observable.create(new Observable.OnSubscribe<Sppjbean>() {
            @Override
            public void call(final Subscriber<? super Sppjbean> subscriber) {
                //Retrofit的请求数据
                Retrofit retrofit=new Retrofit.Builder()
                        //设置网络请求的url
                        .baseUrl(" http://apiv4.yangkeduo.com/reviews/")
                        //设置Gson
                        .addConverterFactory(GsonConverterFactory.create())
                        //设置Rxjava
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                        .build();

                //创建网络请求接口的实例
                Xp_pj_getrequest Request=retrofit.create(Xp_pj_getrequest.class);
                //对发的请求进行封装
                Call<Sppjbean> call=Request.getCall(uid);
                //使用异步发送网络请求
                call.enqueue(new Callback<Sppjbean>(){
                    //请求成功时回调
                    @Override
                    public void onResponse(Call<Sppjbean> call, Response<Sppjbean> response) {
                        sppjbean=response.body();
                        //调用OnNext方法把值传给观察者
                        subscriber.onNext(sppjbean);
                        subscriber.onCompleted();
                    }

                    //请求失败时的回调
                    @Override
                    public void onFailure(Call<Sppjbean> call, Throwable t) {

                    }
                });

            }
        }).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
