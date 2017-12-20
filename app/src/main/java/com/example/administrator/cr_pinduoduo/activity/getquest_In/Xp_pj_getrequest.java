package com.example.administrator.cr_pinduoduo.activity.getquest_In;

import com.example.administrator.cr_pinduoduo.activity.bean.Sppjbean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Administrator on 2017/12/13.
 */


public interface Xp_pj_getrequest {

    @GET("{gid}?page=1&size=2&label=1&is_back=1&pdduid=3470667255")
    Call<Sppjbean> getCall(@Path("gid") int uid);
}
