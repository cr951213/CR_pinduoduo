package com.example.administrator.cr_pinduoduo.activity.persenter;

import android.content.Context;

import com.example.administrator.cr_pinduoduo.activity.bean.GgBean;
import com.example.administrator.cr_pinduoduo.activity.model.Gg_model;
import com.example.administrator.cr_pinduoduo.activity.view.Gg_Iview;

import rx.Observer;

/**
 * Created by Administrator on 2017/12/13.
 */

public class Gg_persenter {

    Context  context;
    Gg_model mm;
    Gg_Iview vv;

    public Gg_persenter(Context context, Gg_Iview vv) {
        this.context = context;
        this.vv = vv;
        mm=new Gg_model();
    }

    public  void getData(int gg_id){
      mm.shuju(new Observer<GgBean>() {
          @Override
          public void onCompleted() {

          }

          @Override
          public void onError(Throwable e) {

          }

          @Override
          public void onNext(GgBean ggBean) {

              vv.ShowView(ggBean);
          }
      },gg_id);
    }

}
