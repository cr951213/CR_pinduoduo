package com.example.administrator.cr_pinduoduo.activity.model;

import com.example.administrator.cr_pinduoduo.activity.bean.FlyBean;
import com.example.administrator.cr_pinduoduo.activity.getquest_In.Fly_getrequest;

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

public class Fly_model implements Fly_Imodel {
    private FlyBean flyBean;
    private String goods_id;

    public Fly_model(String goods_id) {
        this.goods_id = goods_id;
    }

    @Override
    public void shuju(Observer<FlyBean> observer) {
        //创建被观察者
        Observable.create(new Observable.OnSubscribe<FlyBean>() {
            @Override
            public void call(final Subscriber<? super FlyBean> subscriber) {
                //Retrofit的请求数据
                Retrofit retrofit=new Retrofit.Builder()
                        //设置网络请求的url
                        .baseUrl("https://www.zhaoapi.cn/product/")
                        //设置Gson
                        .addConverterFactory(GsonConverterFactory.create())
                        //设置Rxjava
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                        .build();

                //创建网络请求接口的实例
                Fly_getrequest Request=retrofit.create(Fly_getrequest.class);
                //对发的请求进行封装
                Call<FlyBean> call=Request.getCall(goods_id);
                //使用异步发送网络请求
                call.enqueue(new Callback<FlyBean>(){
                    //请求成功时回调
                    @Override
                    public void onResponse(Call<FlyBean> call, Response<FlyBean> response) {
                        flyBean=response.body();
                        //调用OnNext方法把值传给观察者
                        subscriber.onNext(flyBean);
                        subscriber.onCompleted();

                    }

                    //请求失败时的回调
                    @Override
                    public void onFailure(Call<FlyBean> call, Throwable t) {

                    }
                });

            }
        }).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

    }
}
