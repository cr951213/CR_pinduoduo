package com.example.administrator.cr_pinduoduo.activity.getquest_In;

import com.example.administrator.cr_pinduoduo.activity.bean.SysyBean;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Administrator on 2017/12/13.
 */


public interface Sysy_getrequest {
    @GET("getAd")
    Call<SysyBean> getCall();
}
