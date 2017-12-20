package com.example.administrator.cr_pinduoduo.activity.getquest_In;

import com.example.administrator.cr_pinduoduo.activity.bean.XPbean;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Administrator on 2017/12/13.
 */


public interface Xp_getrequest {
    @GET("newlist?page=1&size=20&ver=1512745500001&pdduid=3470667255")
    Call<XPbean> getCall();
}
