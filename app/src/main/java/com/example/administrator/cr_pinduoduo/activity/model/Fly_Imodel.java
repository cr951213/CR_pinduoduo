package com.example.administrator.cr_pinduoduo.activity.model;

import com.example.administrator.cr_pinduoduo.activity.bean.FlyBean;

import rx.Observer;

/**
 * Created by Administrator on 2017/12/13.
 */

public interface Fly_Imodel {
    //将观察者传（bean）进去
    public void shuju(Observer<FlyBean> observer);
}
