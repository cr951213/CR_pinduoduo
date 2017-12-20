package com.example.administrator.cr_pinduoduo.activity.getquest_In;

import com.example.administrator.cr_pinduoduo.activity.bean.GgBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2017/12/13.
 */


public interface Gg_getrequest {

    @GET("mall?pdduid=3470667255")
    Call<GgBean> getCall(@Query("goods_id") int gg_id);
}
