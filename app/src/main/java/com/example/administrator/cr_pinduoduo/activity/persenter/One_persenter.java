package com.example.administrator.cr_pinduoduo.activity.persenter;

import android.content.Context;

import com.example.administrator.cr_pinduoduo.activity.bean.OneBean;
import com.example.administrator.cr_pinduoduo.activity.model.One_model;
import com.example.administrator.cr_pinduoduo.activity.view.One_Iview;

import rx.Observer;

/**
 * Created by Administrator on 2017/12/13.
 */

public class One_persenter {

    Context  context;
    One_model mm;
    One_Iview vv;

    public One_persenter(Context context, One_Iview vv) {
        this.context = context;
        this.vv = vv;
        mm=new One_model();
    }

    public  void getData(){
        mm.shuju(new Observer<OneBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(OneBean oneBean) {

                vv.ShowView(oneBean);
            }
        });
    }

}
