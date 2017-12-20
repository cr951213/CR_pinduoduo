package com.example.administrator.cr_pinduoduo.activity.getquest_In;

import com.example.administrator.cr_pinduoduo.activity.bean.OneBean;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Administrator on 2017/12/13.
 */


public interface One_getrequest {
    @GET("https://www.zhaoapi.cn/product/getCatagory")
    Call<OneBean> getCall();
}
