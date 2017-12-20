package com.example.administrator.cr_pinduoduo.activity.dh_fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.cr_pinduoduo.R;
import com.example.administrator.cr_pinduoduo.activity.adapter.Myss_lsadapter;
import com.example.administrator.cr_pinduoduo.activity.bean.EbsBean;
import com.example.administrator.cr_pinduoduo.activity.bean.SsBean;
import com.example.administrator.cr_pinduoduo.activity.persenter.Sspersenter;
import com.example.administrator.cr_pinduoduo.activity.sousuo.Feagment_sss;
import com.example.administrator.cr_pinduoduo.activity.view.Ss_Iview;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/12/13.
 */

public class Fragment_ss extends Fragment implements Ss_Iview {


    @BindView(R.id.xp_tk)
    TextView xpTk;
    @BindView(R.id.ssbut_ss)
    ImageView ssbutSs;
    @BindView(R.id.ss_ls)
    ListView ssLs;
    @BindView(R.id.ss_frame)
    FrameLayout ssFrame;
    Unbinder unbinder;

    Sspersenter  pp;

    String cid;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.sousuo, null);
        unbinder = ButterKnife.bind(this, view);

        pp=new Sspersenter(getActivity(),this);
        pp.getData();

        //帧布局与Fragment的联动
        FragmentManager manager=getFragmentManager();
        manager.beginTransaction().replace(R.id.ss_frame,new Feagment_sss()).commit();





        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void ShowView(final SsBean ssBean) {

        Myss_lsadapter   myssLsadapter=new Myss_lsadapter(getActivity(),ssBean);
        ssLs.setAdapter(myssLsadapter);

       ssLs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               Toast.makeText(getActivity(),"你点了商品的分类项",Toast.LENGTH_SHORT).show();

                  cid=ssBean.getData().get(i).getCid()+"";

               EbsBean ebsBean=new EbsBean(cid);
               EventBus.getDefault().postSticky(ebsBean);

           }
       });

    }
}
