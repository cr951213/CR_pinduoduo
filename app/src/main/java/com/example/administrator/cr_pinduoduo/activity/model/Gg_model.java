package com.example.administrator.cr_pinduoduo.activity.model;

import com.example.administrator.cr_pinduoduo.activity.bean.GgBean;
import com.example.administrator.cr_pinduoduo.activity.getquest_In.Gg_getrequest;

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

public class Gg_model implements Gg_Imodel {
    private GgBean ggBean;
    private int gg_id;



    @Override
    public void shuju(Observer<GgBean> observer, final int gg_id) {
        //创建被观察者
        Observable.create(new Observable.OnSubscribe<GgBean>() {
            @Override
            public void call(final Subscriber<? super GgBean> subscriber) {
                //Retrofit的请求数据
                Retrofit retrofit=new Retrofit.Builder()
                        //设置网络请求的url
                        .baseUrl("http://apiv4.yangkeduo.com/recommendation/")
                        //设置Gson
                        .addConverterFactory(GsonConverterFactory.create())
                        //设置Rxjava
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                        .build();

                //创建网络请求接口的实例
                Gg_getrequest req=retrofit.create(Gg_getrequest.class);
                //对发的请求进行封装
                Call<GgBean> call=req.getCall(gg_id);
                //使用异步发送网络请求
                call.enqueue(new Callback<GgBean>(){
                    //请求成功时回调
                    @Override
                    public void onResponse(Call<GgBean> call, Response<GgBean> response) {
                        ggBean=response.body();
                        //调用OnNext方法把值传给观察者
                        subscriber.onNext(ggBean);
                        subscriber.onCompleted();
                    }

                    //请求失败时的回调
                    @Override
                    public void onFailure(Call<GgBean> call, Throwable t) {

                    }
                });

            }
        }).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

    }
}
