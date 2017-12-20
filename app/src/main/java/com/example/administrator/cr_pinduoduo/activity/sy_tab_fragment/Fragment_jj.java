package com.example.administrator.cr_pinduoduo.activity.sy_tab_fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/12/13.
 */

public class Fragment_jj extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView   tv=new TextView(getActivity());
        tv.setText("家具");
        return    tv;
    }
}
