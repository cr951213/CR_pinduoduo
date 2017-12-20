package com.example.administrator.cr_pinduoduo.activity.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.cr_pinduoduo.R;
import com.zhy.autolayout.AutoLayoutActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Wd_dlActivity extends AutoLayoutActivity {



    @BindView(R.id.but_gb)
    TextView butGb;
    @BindView(R.id.dl_fs)
    ImageView dlFs;
    @BindView(R.id.but_dll)
    Button butDll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wd_dl);
        ButterKnife.bind(this);


    }


    @OnClick({R.id.but_gb, R.id.dl_fs})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.but_gb:
                finish();
                break;
            case R.id.dl_fs:
                break;
        }
    }

    @OnClick(R.id.but_dll)
    public void onViewClicked() {
        Intent   intent=new Intent(Wd_dlActivity.this,Weixin_dlActivity.class);
        startActivity(intent);
    }
}
