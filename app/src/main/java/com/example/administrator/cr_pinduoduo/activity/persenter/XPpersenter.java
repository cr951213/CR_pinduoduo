package com.example.administrator.cr_pinduoduo.activity.persenter;

import android.content.Context;

import com.example.administrator.cr_pinduoduo.activity.bean.XPbean;
import com.example.administrator.cr_pinduoduo.activity.model.XP_model;
import com.example.administrator.cr_pinduoduo.activity.view.XP_Iview;

import rx.Observer;

/**
 * Created by Administrator on 2017/12/13.
 */

public class XPpersenter {

    Context  context;
    XP_model    mm;
    XP_Iview vv;

    public XPpersenter(Context context, XP_Iview vv) {
        this.context = context;
        this.vv = vv;
        mm=new XP_model();
    }

    public  void getData(){
        mm.shuju(new Observer<XPbean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(XPbean xPbean) {

                vv.ShowView(xPbean);
            }
        });
    }

}
