package com.example.administrator.cr_pinduoduo.activity.persenter;

import android.content.Context;

import com.example.administrator.cr_pinduoduo.activity.bean.SysyBean;
import com.example.administrator.cr_pinduoduo.activity.model.Sysy_model;
import com.example.administrator.cr_pinduoduo.activity.view.Sysy_Iview;

import rx.Observer;

/**
 * Created by Administrator on 2017/12/13.
 */

public class Sysy_persenter {

    Context  context;
    Sysy_model mm;
    Sysy_Iview vv;

    public Sysy_persenter(Context context, Sysy_Iview vv) {
        this.context = context;
        this.vv = vv;
        mm=new Sysy_model();
    }

    public  void getData(){
        mm.shuju(new Observer<SysyBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(SysyBean sysyBean) {

                vv.ShowView(sysyBean);
            }
        });
    }

}
