package com.example.administrator.cr_pinduoduo.activity.weixin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.cr_pinduoduo.R;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;


/**
 * 分享，收藏，登录的回调
 */
public class WXEntryActivity extends AppCompatActivity implements IWXAPIEventHandler {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wxentry);
    }

    /**
     * 请求
     * @param baseReq
     */
    @Override
    public void onReq(BaseReq baseReq) {

    }

    /**
     * 响应
     * @param baseResp
     */
    @Override
    public void onResp(BaseResp baseResp) {

    }
}
