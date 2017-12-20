package com.example.administrator.cr_pinduoduo.activity.gr_Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.cr_pinduoduo.R;
import com.example.administrator.cr_pinduoduo.activity.adapter.One_adapter;
import com.example.administrator.cr_pinduoduo.activity.bean.OneBean;
import com.example.administrator.cr_pinduoduo.activity.persenter.One_persenter;
import com.example.administrator.cr_pinduoduo.activity.view.One_Iview;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/12/18.
 */

public class Fragment_one extends Fragment implements One_Iview {

    One_persenter pp;
    @BindView(R.id.one_rv)
    RecyclerView oneRv;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = View.inflate(getActivity(), R.layout.fg_one, null);
        unbinder = ButterKnife.bind(this, view);

        pp=new One_persenter(getActivity(),this);
        pp.getData();


        return view;

    }

    @Override
    public void ShowView(OneBean oneBean) {

        GridLayoutManager   manager=new GridLayoutManager(getActivity(),5);
        oneRv.setLayoutManager(manager);
        One_adapter   oneAdapter=new One_adapter(getActivity(),oneBean);
        oneRv.setAdapter(oneAdapter);



    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
