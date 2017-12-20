package com.example.administrator.cr_pinduoduo.activity.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;
import com.example.administrator.cr_pinduoduo.R;
import com.example.administrator.cr_pinduoduo.activity.adapter.XP2adapter;
import com.example.administrator.cr_pinduoduo.activity.adapter.XP_pjadapter;
import com.example.administrator.cr_pinduoduo.activity.bean.Sppjbean;
import com.example.administrator.cr_pinduoduo.activity.bean.Xp_xpbean;
import com.example.administrator.cr_pinduoduo.activity.persenter.XP_pj_persenter;
import com.example.administrator.cr_pinduoduo.activity.persenter.XP_xp_persenter;
import com.example.administrator.cr_pinduoduo.activity.view.XP_pj_Iview;
import com.example.administrator.cr_pinduoduo.activity.view.XP_xp_Iview;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.stx.xhb.xbanner.XBanner;
import com.zhy.autolayout.AutoLayoutActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class XP_xqActivity extends AutoLayoutActivity implements XP_xp_Iview, XP_pj_Iview {

    int goods_id;
    int mid;

    @BindView(R.id.xp_xp_price)
    TextView xpXpPrice;
    XP_xp_persenter pp;
    @BindView(R.id.banner_1)
    XBanner banner1;

    List<String> list;
    @BindView(R.id.xp_xp_price2)
    TextView xpXpPrice2;
    @BindView(R.id.xp_xp_pd)
    TextView xpXpPd;
    @BindView(R.id.xp_xp_title)
    TextView xpXpTitle;
    @BindView(R.id.vf)
    ViewFlipper vf;

    TextView tvHour;
    TextView tvHour2;
    TextView tvMinute;
    TextView tvMinute2;
    TextView tvSecond;
    TextView tvSecond2;
    @BindView(R.id.sp_pj_rv)
    RecyclerView spPjRv;
    @BindView(R.id.but_jdgg)
    ImageView butJdgg;
    @BindView(R.id.xp_tv_xp)
    TextView xpTvXp;
    @BindView(R.id.sp_xp_xp_rv)
    RecyclerView spXpXpRv;


    private long mHour = 02;
    private long mMin = 15;
    private long mSecond = 36;
    private boolean isRun = true;

    private Handler timeHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                computeTime();
                if (mHour < 10) {
                    tvHour.setText("0" + mHour + "");
                } else {
                    tvHour.setText("0" + mHour + "");
                }
                if (mMin < 10) {
                    tvMinute.setText("0" + mMin + "");
                } else {
                    tvMinute.setText(mMin + "");
                }
                if (mSecond < 10) {
                    tvSecond.setText("0" + mSecond + "");
                } else {
                    tvSecond.setText(mSecond + "");
                }
            }
        }
    };

    XP_pj_persenter pjpp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_xp_xq);
        ButterKnife.bind(this);

        final Intent intent = getIntent();
        goods_id = intent.getIntExtra("gid", 0);


        pp = new XP_xp_persenter(this, this);
        pp.getData(goods_id);

        pjpp = new XP_pj_persenter(this, this);
        pjpp.getData(goods_id);

        View view = View.inflate(XP_xqActivity.this, R.layout.pmd_item, null);
        vf.addView(view);
        View view2 = View.inflate(XP_xqActivity.this, R.layout.pmd_item2, null);
        vf.addView(view2);

        SimpleDraweeView img = view.findViewById(R.id.xprv_img3);
        SimpleDraweeView img2 = view.findViewById(R.id.xprv_img4);
        tvHour = view.findViewById(R.id.tv_hour);
        tvHour2 = view.findViewById(R.id.tv_hour2);
        tvMinute = view.findViewById(R.id.tv_minute);
        tvMinute2 = view.findViewById(R.id.tv_minute2);
        tvSecond = view.findViewById(R.id.tv_second);
        tvSecond2 = view.findViewById(R.id.tv_second2);


        DraweeController dc = Fresco.newDraweeControllerBuilder()
                .setUri("http://avatar.yangkeduo.com/a/eb642f3405daa46b7d03dd54148ec641881fe0d7-1512175275?x-oss-process=image/resize,w_100")
                .setAutoPlayAnimations(true)
                .build();
        img.setController(dc);

        DraweeController dc2 = Fresco.newDraweeControllerBuilder()
                .setUri("http://avatar.yangkeduo.com/a/2564bbb7b20a0095aaf40e92d8e99a26547d86b4-1512719976?x-oss-process=image/resize,w_100")
                .setAutoPlayAnimations(true)
                .build();
        img2.setController(dc2);

        startRun();

        butJdgg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(XP_xqActivity.this, JdggActivity.class);
                intent1.putExtra("goods_id", goods_id);
                startActivity(intent1);
            }
        });

    }

    @Override
    public void ShowView(Xp_xpbean xpXpbean) {

        list = new ArrayList<>();
        for (int i = 0; i < xpXpbean.getSku().size(); i++) {
            list.add(xpXpbean.getSku().get(i).getThumb_url());
            xpXpPrice.setText("￥" + xpXpbean.getSku().get(i).getNormal_price() + "");
            xpXpPrice2.setText("￥" + xpXpbean.getSku().get(i).getGroup_price() + "");
            xpXpPd.setText("已拼" + xpXpbean.getSku().get(i).getSpec() + "件.2人拼单");
        }
        banner1.setData(list);
        banner1.setmAdapter(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, View view, int position) {
                Glide.with(XP_xqActivity.this).load(list.get(position)).into((ImageView) view);
            }
        });
        xpXpTitle.setText(xpXpbean.getGoods_name());

        xpTvXp.setText(xpXpbean.getShare_desc());

        LinearLayoutManager manager=new LinearLayoutManager(this);
        spXpXpRv.setLayoutManager(manager);
        XP2adapter   xp2adapter=new XP2adapter(this,xpXpbean);
        spXpXpRv.setAdapter(xp2adapter);

    }

    /**
     * 开启倒计时
     */
    private void startRun() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                while (isRun) {
                    try {
                        Thread.sleep(1000); // sleep 1000ms
                        Message message = Message.obtain();
                        message.what = 1;
                        timeHandler.sendMessage(message);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    /**
     * 倒计时计算
     */
    private void computeTime() {
        mSecond--;
        if (mSecond < 0) {
            mMin--;
            mSecond = 59;
            if (mMin < 0) {
                mMin = 59;
                mHour--;
            }
        }
    }


    @Override
    public void ShowView(Sppjbean sppjbean) {

        LinearLayoutManager manager = new LinearLayoutManager(this);
        spPjRv.setLayoutManager(manager);
        spPjRv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        XP_pjadapter pjada = new XP_pjadapter(this, sppjbean);
        spPjRv.setAdapter(pjada);


    }


}
