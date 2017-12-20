package com.example.administrator.cr_pinduoduo.activity.persenter;

import android.content.Context;

import com.example.administrator.cr_pinduoduo.activity.bean.SsBean;
import com.example.administrator.cr_pinduoduo.activity.model.Ss_model;
import com.example.administrator.cr_pinduoduo.activity.view.Ss_Iview;

import rx.Observer;

/**
 * Created by Administrator on 2017/12/13.
 */

public class Sspersenter {

    Context  context;
    Ss_model mm;
    Ss_Iview vv;

    public Sspersenter(Context context, Ss_Iview vv) {
        this.context = context;
        this.vv = vv;
        mm=new Ss_model();
    }

    public  void getData(){
        mm.shuju(new Observer<SsBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(SsBean ssBean) {

                vv.ShowView(ssBean);
            }
        });
    }

}
