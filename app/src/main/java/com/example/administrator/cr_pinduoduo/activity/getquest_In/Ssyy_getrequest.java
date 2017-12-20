package com.example.administrator.cr_pinduoduo.activity.getquest_In;

import com.example.administrator.cr_pinduoduo.activity.bean.SsyyBean;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Administrator on 2017/12/13.
 */


public interface Ssyy_getrequest {
    @GET("http://120.27.23.105/product/getProductCatagory")
    Call<SsyyBean> getCall();
}
