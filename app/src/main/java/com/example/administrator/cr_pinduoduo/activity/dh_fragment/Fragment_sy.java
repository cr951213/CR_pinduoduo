package com.example.administrator.cr_pinduoduo.activity.dh_fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.cr_pinduoduo.R;
import com.example.administrator.cr_pinduoduo.activity.sy_tab_fragment.Fragment_dq;
import com.example.administrator.cr_pinduoduo.activity.sy_tab_fragment.Fragment_fs;
import com.example.administrator.cr_pinduoduo.activity.sy_tab_fragment.Fragment_jf;
import com.example.administrator.cr_pinduoduo.activity.sy_tab_fragment.Fragment_jj;
import com.example.administrator.cr_pinduoduo.activity.sy_tab_fragment.Fragment_ms;
import com.example.administrator.cr_pinduoduo.activity.sy_tab_fragment.Fragment_my;
import com.example.administrator.cr_pinduoduo.activity.sy_tab_fragment.Fragment_mz;
import com.example.administrator.cr_pinduoduo.activity.sy_tab_fragment.Fragment_nz;
import com.example.administrator.cr_pinduoduo.activity.sy_tab_fragment.Fragment_sg;
import com.example.administrator.cr_pinduoduo.activity.sy_tab_fragment.Fragment_sj;
import com.example.administrator.cr_pinduoduo.activity.sy_tab_fragment.Fragment_syy;
import com.example.administrator.cr_pinduoduo.activity.sy_tab_fragment.Fragment_xb;
import com.example.administrator.cr_pinduoduo.activity.sy_tab_fragment.Fragment_yd;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/12/13.
 */

public class Fragment_sy extends Fragment {
    @BindView(R.id.sy_tab)
    TabLayout syTab;
    @BindView(R.id.sy_tab_vp)
    ViewPager syTabVp;
    Unbinder unbinder;

    List<String>   list;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.sy, null);

        unbinder = ButterKnife.bind(this, view);

        addjihe();
        MyTabadapter  tabvpada=new MyTabadapter(getChildFragmentManager());
        syTabVp.setAdapter(tabvpada);

        syTab.setTabMode(TabLayout.MODE_SCROLLABLE);
        syTab.setupWithViewPager(syTabVp);



        return view;
    }

    private void addjihe() {
        list=new ArrayList<>();
        list.add("首页");
        list.add("服饰");
        list.add("男装");
        list.add("鞋包");
        list.add("母婴");
        list.add("家具");
        list.add("电器");
        list.add("美食");
        list.add("家纺");
        list.add("美妆");
        list.add("手机");
        list.add("水果");
        list.add("运动");
    }



    class  MyTabadapter extends FragmentPagerAdapter{

        public MyTabadapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment   fm=null;
            switch (position)
            {
                case 0:
                    fm=new Fragment_syy();
                    break;
                case 1:
                    fm=new Fragment_fs();
                    break;
                case 2:
                    fm=new Fragment_nz();
                    break;
                case 3:
                    fm=new Fragment_xb();
                    break;
                case 4:
                    fm=new Fragment_my();
                    break;
                case 5:
                    fm=new Fragment_jj();
                    break;
                case 6:
                    fm=new Fragment_dq();
                    break;
                case 7:
                    fm=new Fragment_ms();
                    break;
                case 8:
                    fm=new Fragment_jf();
                    break;
                case 9:
                    fm=new Fragment_mz();
                    break;
                case 10:
                    fm=new Fragment_sj();
                    break;
                case 11:
                    fm=new Fragment_sg();
                    break;
                case 12:
                    fm=new Fragment_yd();
                    break;

            }
            return fm;
        }

        @Override
        public int getCount() {
            return 13;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return list.get(position);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}
