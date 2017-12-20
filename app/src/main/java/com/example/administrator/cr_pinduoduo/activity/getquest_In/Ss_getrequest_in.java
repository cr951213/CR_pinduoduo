package com.example.administrator.cr_pinduoduo.activity.getquest_In;

import com.example.administrator.cr_pinduoduo.activity.bean.SsBean;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Administrator on 2017/12/16.
 */

public interface Ss_getrequest_in {
    @GET("getCatagory")
    Call<SsBean> getCall();
}
