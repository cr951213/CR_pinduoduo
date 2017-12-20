package com.example.administrator.cr_pinduoduo.activity.persenter;

import android.content.Context;

import com.example.administrator.cr_pinduoduo.activity.bean.Xp_xpbean;
import com.example.administrator.cr_pinduoduo.activity.model.XP_xp_model;
import com.example.administrator.cr_pinduoduo.activity.view.XP_xp_Iview;

import rx.Observer;

/**
 * Created by Administrator on 2017/12/13.
 */

public class XP_xp_persenter {

    Context  context;
    XP_xp_model    mm;
    XP_xp_Iview vv;

    public XP_xp_persenter(Context context, XP_xp_Iview vv) {
        this.context = context;
        this.vv = vv;
        mm=new XP_xp_model();
    }

    public  void getData(int goods_id){
      mm.shuju(new Observer<Xp_xpbean>() {
          @Override
          public void onCompleted() {

          }

          @Override
          public void onError(Throwable e) {

          }

          @Override
          public void onNext(Xp_xpbean xp_xpbean) {

              vv.ShowView(xp_xpbean);
          }
      },goods_id);
    }

}
