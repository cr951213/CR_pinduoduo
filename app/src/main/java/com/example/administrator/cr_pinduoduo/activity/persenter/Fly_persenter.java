package com.example.administrator.cr_pinduoduo.activity.persenter;

import android.content.Context;

import com.example.administrator.cr_pinduoduo.activity.bean.FlyBean;
import com.example.administrator.cr_pinduoduo.activity.model.Fly_model;
import com.example.administrator.cr_pinduoduo.activity.view.Fly_Iview;

import rx.Observer;

/**
 * Created by Administrator on 2017/12/13.
 */

public class Fly_persenter {

    Context  context;
    Fly_model mm;
    Fly_Iview vv;
    String   cid;

    public Fly_persenter(Context context, Fly_Iview vv,String   cid) {
        this.context = context;
        this.vv = vv;
        this.cid=cid;
        mm=new Fly_model(cid);
    }

    public  void getData(){
     mm.shuju(new Observer<FlyBean>() {
         @Override
         public void onCompleted() {

         }

         @Override
         public void onError(Throwable e) {

         }

         @Override
         public void onNext(FlyBean flyBean) {
             vv.ShowView(flyBean);
         }
     });
    }

}
