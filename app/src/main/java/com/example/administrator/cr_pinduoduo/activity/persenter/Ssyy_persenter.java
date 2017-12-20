package com.example.administrator.cr_pinduoduo.activity.persenter;

import android.content.Context;

import com.example.administrator.cr_pinduoduo.activity.bean.SsyyBean;
import com.example.administrator.cr_pinduoduo.activity.model.Ssyy_model;
import com.example.administrator.cr_pinduoduo.activity.view.Ssyy_Iview;

import rx.Observer;

/**
 * Created by Administrator on 2017/12/13.
 */

public class Ssyy_persenter {

    Context  context;
    Ssyy_model mm;
    Ssyy_Iview vv;

    public Ssyy_persenter(Context context, Ssyy_Iview vv) {
        this.context = context;
        this.vv = vv;
        mm=new Ssyy_model();
    }

    public  void getData(){
        mm.shuju(new Observer<SsyyBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(SsyyBean ssyyBean) {

                vv.ShowView(ssyyBean);

            }
        });
    }

}
