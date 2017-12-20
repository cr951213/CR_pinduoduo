package com.example.administrator.cr_pinduoduo.activity.sousuo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.cr_pinduoduo.R;
import com.example.administrator.cr_pinduoduo.activity.adapter.Ssyyadapter;
import com.example.administrator.cr_pinduoduo.activity.bean.EbsBean;
import com.example.administrator.cr_pinduoduo.activity.bean.FlyBean;
import com.example.administrator.cr_pinduoduo.activity.persenter.Fly_persenter;
import com.example.administrator.cr_pinduoduo.activity.view.Fly_Iview;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/12/16.
 */

public class Feagment_sss extends Fragment implements Fly_Iview{

    @BindView(R.id.ss_rv)
    RecyclerView ssRv;
    Unbinder unbinder;
    Fly_persenter pp;
    String   cid;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //注册
        EventBus.getDefault().register(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.sousuo_you, null);
        unbinder = ButterKnife.bind(this, view);


    return view;
    }



    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void eventBusReceive(EbsBean ebsBean) {
        cid=ebsBean.getCid();
        pp=new Fly_persenter(getActivity(),this,cid);
        pp.getData();
        Log.i("***********",cid+"");


    }


    @Override
    public void ShowView(FlyBean flyBean) {
        GridLayoutManager   manager=new GridLayoutManager(getActivity(),4);
        ssRv.setLayoutManager(manager);
        Ssyyadapter  ssyyadapter=new Ssyyadapter(getActivity(),flyBean);
        ssRv.setAdapter(ssyyadapter);
        ssyyadapter.notifyDataSetChanged();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        EventBus.getDefault().unregister(getActivity());
    }


}
