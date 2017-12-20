package com.example.administrator.cr_pinduoduo.activity.persenter;

import android.content.Context;

import com.example.administrator.cr_pinduoduo.activity.bean.Sppjbean;
import com.example.administrator.cr_pinduoduo.activity.model.XP_pj_model;
import com.example.administrator.cr_pinduoduo.activity.view.XP_pj_Iview;

import rx.Observer;

/**
 * Created by Administrator on 2017/12/13.
 */

public class XP_pj_persenter {

    Context  context;
    XP_pj_model    mm;
    XP_pj_Iview vv;

    public XP_pj_persenter(Context context, XP_pj_Iview vv) {
        this.context = context;
        this.vv = vv;
        mm=new XP_pj_model();
    }

    public  void getData(int uid){
      mm.shuju(new Observer<Sppjbean>() {
          @Override
          public void onCompleted() {

          }

          @Override
          public void onError(Throwable e) {

          }

          @Override
          public void onNext(Sppjbean sppjbean) {

              vv.ShowView(sppjbean);
          }
      },uid);
    }

}
