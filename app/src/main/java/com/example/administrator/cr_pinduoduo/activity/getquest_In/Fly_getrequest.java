package com.example.administrator.cr_pinduoduo.activity.getquest_In;

import com.example.administrator.cr_pinduoduo.activity.bean.FlyBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2017/12/13.
 */


public interface Fly_getrequest {

    @GET("getProductCatagory")
    Call<FlyBean> getCall(@Query("gid") String uid);
}
