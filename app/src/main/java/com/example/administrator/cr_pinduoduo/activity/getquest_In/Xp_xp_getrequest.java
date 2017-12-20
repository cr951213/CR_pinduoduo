package com.example.administrator.cr_pinduoduo.activity.getquest_In;

import com.example.administrator.cr_pinduoduo.activity.bean.Xp_xpbean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Administrator on 2017/12/13.
 */


public interface Xp_xp_getrequest {



    @GET("{gid}?pdduid=3470667255")
    Call<Xp_xpbean> getCall(@Path("gid") int goods_id);
}
