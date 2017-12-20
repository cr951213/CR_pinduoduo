package com.example.administrator.cr_pinduoduo.activity.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.cr_pinduoduo.R;
import com.example.administrator.cr_pinduoduo.activity.adapter.Gjgg_Padapter;
import com.example.administrator.cr_pinduoduo.activity.bean.GgBean;
import com.example.administrator.cr_pinduoduo.activity.persenter.Gg_persenter;
import com.example.administrator.cr_pinduoduo.activity.view.Gg_Iview;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.zhy.autolayout.AutoLayoutActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class JdggActivity extends AutoLayoutActivity implements Gg_Iview {

    int gid;
    Gg_persenter ggpp;

    @BindView(R.id.but_pj_fh)
    TextView butPjFh;
    @BindView(R.id.pj_xs)
    ImageView pjXs;
    @BindView(R.id.jd_gg_rv)
    RecyclerView jdGgRv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_jdgg);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        gid = intent.getIntExtra("goods_id", 0);

        ggpp = new Gg_persenter(this, this);
        ggpp.getData(gid);
        Log.i("<<<<<<<<<<<<<<",gid+"");

        butPjFh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });

    }

    @Override
    public void ShowView(GgBean ggBean) {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        jdGgRv.setLayoutManager(manager);

        Gjgg_Padapter   gjggPadapter=new Gjgg_Padapter(this,ggBean);
        jdGgRv.setAdapter(gjggPadapter);
        Log.i("++++++++++",ggBean.toString());

    }
}
