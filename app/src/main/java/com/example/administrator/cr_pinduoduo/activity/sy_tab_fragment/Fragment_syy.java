package com.example.administrator.cr_pinduoduo.activity.sy_tab_fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.cr_pinduoduo.R;
import com.example.administrator.cr_pinduoduo.activity.adapter.Syrv2_adapter;
import com.example.administrator.cr_pinduoduo.activity.bean.SysyBean;
import com.example.administrator.cr_pinduoduo.activity.bean.XPbean;
import com.example.administrator.cr_pinduoduo.activity.gr_Fragment.Fragment_one;
import com.example.administrator.cr_pinduoduo.activity.gr_Fragment.Fragment_two;
import com.example.administrator.cr_pinduoduo.activity.persenter.Sysy_persenter;
import com.example.administrator.cr_pinduoduo.activity.persenter.XPpersenter;
import com.example.administrator.cr_pinduoduo.activity.view.Sysy_Iview;
import com.example.administrator.cr_pinduoduo.activity.view.XP_Iview;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/12/13.
 */

public class Fragment_syy extends Fragment implements XP_Iview, Sysy_Iview {
    @BindView(R.id.banner_2)
    XBanner banner2;
    Unbinder unbinder;
    Sysy_persenter pp;
    List<String> list;
    @BindView(R.id.sy_gr)
    ViewPager syGr;
    @BindView(R.id.but_gr1)
    TextView butGr1;
    @BindView(R.id.but_gr2)
    TextView butGr2;
    @BindView(R.id.sysy_rv2)
    RecyclerView sysyRv2;

    XPpersenter   pp2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.sy_sy, null);
        unbinder = ButterKnife.bind(this, view);

        pp = new Sysy_persenter(getActivity(), this);
        pp.getData();

        pp2=new XPpersenter(getActivity(),this);
        pp2.getData();

        Mygradapter grada = new Mygradapter(getChildFragmentManager());
        syGr.setAdapter(grada);
        syGr.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                switch (position) {
                    case 0:
                        butGr1.setBackgroundColor(Color.RED);
                        butGr2.setBackgroundColor(Color.GREEN);
                        break;
                    case 1:
                        butGr1.setBackgroundColor(Color.GREEN);
                        butGr2.setBackgroundColor(Color.RED);
                        break;

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

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
    public void ShowView(SysyBean sysyBean) {

        list = new ArrayList<>();
        for (int i = 0; i < sysyBean.getData().size(); i++) {
            list.add(sysyBean.getData().get(i).getIcon());
        }
        banner2.setData(list);

        banner2.setmAdapter(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, View view, int position) {
                Glide.with(getActivity()).load(list.get(position)).into((ImageView) view);
            }
        });
    }

    @OnClick({R.id.but_gr1, R.id.but_gr2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.but_gr1:
                syGr.setCurrentItem(0);
                break;
            case R.id.but_gr2:
                syGr.setCurrentItem(1);
                break;
        }
    }

    @Override
    public void ShowView(XPbean xPbean) {

        LinearLayoutManager  manager=new LinearLayoutManager(getActivity());
        sysyRv2.setLayoutManager(manager);
        Syrv2_adapter   syrv2Adapter=new Syrv2_adapter(getActivity(),xPbean);
        sysyRv2.setAdapter(syrv2Adapter);


    }

    class Mygradapter extends FragmentPagerAdapter {

        public Mygradapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fm = null;
            switch (position) {
                case 0:
                    fm = new Fragment_one();
                    break;
                case 1:
                    fm = new Fragment_two();
                    break;

            }
            return fm;
        }

        @Override
        public int getCount() {
            return 2;
        }
    }


}
