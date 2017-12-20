package com.example.administrator.cr_pinduoduo.activity.dh_fragment;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.cr_pinduoduo.R;
import com.example.administrator.cr_pinduoduo.activity.activity.XP_xqActivity;
import com.example.administrator.cr_pinduoduo.activity.adapter.XPadapter;
import com.example.administrator.cr_pinduoduo.activity.bean.XPbean;
import com.example.administrator.cr_pinduoduo.activity.persenter.XPpersenter;
import com.example.administrator.cr_pinduoduo.activity.view.XP_Iview;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/12/13.
 */

public class Fragment_xp extends Fragment implements XP_Iview {
    @BindView(R.id.xp_rv)
    RecyclerView xpRv;
    Unbinder unbinder;
    XPpersenter xpp;
    @BindView(R.id.layout_swipe_refresh)
    SwipeRefreshLayout layoutSwipeRefresh;
    @BindView(R.id.xp_tk)
    TextView xpTk;
    private View inflate;
    private Dialog dialog;
    Button    but_qx;
    ImageView   but_wx,but_qq,but_qqkj;
    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.xp, null);

        unbinder = ButterKnife.bind(this, view);

        xpp = new XPpersenter(getActivity(), this);
        xpp.getData();

        xpTk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog=new Dialog(getActivity());
                inflate = LayoutInflater.from(getActivity()).inflate(R.layout.xp_dialog, null);
                but_qx =inflate.findViewById(R.id.but_qx);
                but_wx=inflate.findViewById(R.id.wx);
                but_qq=inflate.findViewById(R.id.qq);
                but_qqkj=inflate.findViewById(R.id.qqkj);
                dialog.setContentView(inflate);
                Window  window=dialog.getWindow();
                window.setGravity(Gravity.BOTTOM);
                WindowManager.LayoutParams  lp=window.getAttributes();
                lp.y=1;
                window.setAttributes(lp);
                dialog.show();

                but_wx.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getActivity(),"您点击的是微信！！！",Toast.LENGTH_SHORT).show();
                    }
                });
                but_qq.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getActivity(),"您点击的是QQ！！！",Toast.LENGTH_SHORT).show();
                    }
                });
                but_qqkj.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getActivity(),"您点击的是QQ空间！！！",Toast.LENGTH_SHORT).show();
                    }
                });

                but_qx.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

            }
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void ShowView(final XPbean xPbean) {
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 2);
        xpRv.setLayoutManager(manager);

        final XPadapter xpapadapter = new XPadapter(getActivity(), xPbean);
        xpRv.setAdapter(xpapadapter);

        //刷新
        layoutSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                xpRv.setAdapter(xpapadapter);
                xpapadapter.notifyDataSetChanged();
                layoutSwipeRefresh.setRefreshing(false);
            }
        });

        //点击事件
        xpapadapter.setOnItemClickLinstener(new XPadapter.OnItemClickLinstener() {
            @Override
            public void OnItemClick(View view, int position) {

                Intent   intent=new Intent(getActivity(), XP_xqActivity.class);
                intent.putExtra("gid",xPbean.getGoods_list().get(position).getGoods_id());
                intent.putExtra("mid",xPbean.getGoods_list().get(position).getMall_id());
                //Log.i("===========",xPbean.getGoods_list().get(position).getGoods_id()+"");
                startActivity(intent);



            }
        });


    }
}
