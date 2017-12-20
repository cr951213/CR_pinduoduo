package com.example.administrator.cr_pinduoduo.activity.model;

import com.example.administrator.cr_pinduoduo.activity.bean.SsyyBean;
import com.example.administrator.cr_pinduoduo.activity.getquest_In.Ssyy_getrequest;

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

public class Ssyy_model implements Ssyy_Imodel {

    private SsyyBean ssyyBean;

    @Override
    public void shuju(Observer<SsyyBean> observer) {
        //创建被观察者
        Observable.create(new Observable.OnSubscribe<SsyyBean>() {
            @Override
            public void call(final Subscriber<? super SsyyBean> subscriber) {
                //Retrofit的请求数据
                Retrofit retrofit=new Retrofit.Builder()
                        //设置网络请求的url
                        .baseUrl("http://120.27.23.105/product/")
                        //设置Gson
                        .addConverterFactory(GsonConverterFactory.create())
                        //设置Rxjava
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                        .build();

                //创建网络请求接口的实例
                Ssyy_getrequest Request=retrofit.create(Ssyy_getrequest.class);
                //对发的请求进行封装
                Call<SsyyBean> call=Request.getCall();
                //使用异步发送网络请求
                call.enqueue(new Callback<SsyyBean>(){
                    //请求成功时回调
                    @Override
                    public void onResponse(Call<SsyyBean> call, Response<SsyyBean> response) {
                        ssyyBean=response.body();
                        //调用OnNext方法把值传给观察者
                        subscriber.onNext(ssyyBean);

                        subscriber.onCompleted();
                    }

                    //请求失败时的回调
                    @Override
                    public void onFailure(Call<SsyyBean> call, Throwable t) {

                    }
                });

            }
        }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);




    }
}
