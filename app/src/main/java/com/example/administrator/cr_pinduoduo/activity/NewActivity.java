package com.example.administrator.cr_pinduoduo.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.example.administrator.cr_pinduoduo.R;
import com.example.administrator.cr_pinduoduo.activity.dh_fragment.Fragment_grzx;
import com.example.administrator.cr_pinduoduo.activity.dh_fragment.Fragment_lt;
import com.example.administrator.cr_pinduoduo.activity.dh_fragment.Fragment_ss;
import com.example.administrator.cr_pinduoduo.activity.dh_fragment.Fragment_sy;
import com.example.administrator.cr_pinduoduo.activity.dh_fragment.Fragment_xp;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.zhy.autolayout.AutoLayoutActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NewActivity extends AutoLayoutActivity {

    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.sy)
    ImageView sy;
    @BindView(R.id.xp)
    ImageView xp;
    @BindView(R.id.ss)
    ImageView ss;
    @BindView(R.id.lt)
    ImageView lt;
    @BindView(R.id.grzx)
    ImageView grzx;
    @BindView(R.id.radioGroup)
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_new);
        ButterKnife.bind(this);

        MyRVadaptrer   rvadapter=new MyRVadaptrer(getSupportFragmentManager());
        vp.setAdapter(rvadapter);

        sy.setImageResource(R.drawable.sy1);
        xp.setImageResource(R.drawable.xp1);
        ss.setImageResource(R.drawable.ss1);
        lt.setImageResource(R.drawable.lt1);
        grzx.setImageResource(R.drawable.grzx1);
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                switch (position)
                {
                    case 0:
                        sy.setImageResource(R.drawable.sy1);
                        xp.setImageResource(R.drawable.xp1);
                        ss.setImageResource(R.drawable.ss1);
                        lt.setImageResource(R.drawable.lt1);
                        grzx.setImageResource(R.drawable.grzx1);
                        break;
                    case 1:
                        sy.setImageResource(R.drawable.sy2);
                        xp.setImageResource(R.drawable.xp2);
                        ss.setImageResource(R.drawable.ss1);
                        lt.setImageResource(R.drawable.lt1);
                        grzx.setImageResource(R.drawable.grzx1);
                        break;
                    case 2:
                        sy.setImageResource(R.drawable.sy2);
                        xp.setImageResource(R.drawable.xp1);
                        ss.setImageResource(R.drawable.ss2);
                        lt.setImageResource(R.drawable.lt1);
                        grzx.setImageResource(R.drawable.grzx1);
                        break;
                    case 3:
                        sy.setImageResource(R.drawable.sy2);
                        xp.setImageResource(R.drawable.xp1);
                        ss.setImageResource(R.drawable.ss1);
                        lt.setImageResource(R.drawable.lt2);
                        grzx.setImageResource(R.drawable.grzx1);
                        break;
                    case 4:
                        sy.setImageResource(R.drawable.sy2);
                        xp.setImageResource(R.drawable.xp1);
                        ss.setImageResource(R.drawable.ss1);
                        lt.setImageResource(R.drawable.lt1);
                        grzx.setImageResource(R.drawable.grzx2);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



    }

    @OnClick({R.id.sy, R.id.xp, R.id.ss, R.id.lt, R.id.grzx})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.sy:
                vp.setCurrentItem(0);
                break;
            case R.id.xp:
                vp.setCurrentItem(1);
                break;
            case R.id.ss:
                vp.setCurrentItem(2);
                break;
            case R.id.lt:
                vp.setCurrentItem(3);
                break;
            case R.id.grzx:
                vp.setCurrentItem(4);
                break;
        }
    }

    class  MyRVadaptrer extends FragmentPagerAdapter{

        public MyRVadaptrer(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fm=null;
            switch (position)
            {
                case 0:
                    fm=new Fragment_sy();
                    break;
                case 1:
                    fm=new Fragment_xp();
                    break;
                case 2:
                    fm=new Fragment_ss();
                    break;
                case 3:
                    fm=new Fragment_lt();
                    break;
                case 4:
                    fm=new Fragment_grzx();
                    break;

            }
            return fm;
        }

        @Override
        public int getCount() {
            return 5;
        }
    }


}
