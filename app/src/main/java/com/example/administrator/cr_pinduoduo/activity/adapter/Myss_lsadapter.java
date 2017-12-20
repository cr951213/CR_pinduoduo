package com.example.administrator.cr_pinduoduo.activity.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.cr_pinduoduo.R;
import com.example.administrator.cr_pinduoduo.activity.bean.SsBean;

/**
 * Created by Administrator on 2017/12/16.
 */

public class Myss_lsadapter extends BaseAdapter{

    Context  context;
    SsBean   ssBean;

    public Myss_lsadapter(Context context, SsBean ssBean) {
        this.context = context;
        this.ssBean = ssBean;
    }

    @Override
    public int getCount() {
        return ssBean.getData().size();
    }

    @Override
    public Object getItem(int i) {
        return 1;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view=View.inflate(context, R.layout.ss_ls_item,null);
        TextView   tv=view.findViewById(R.id.ssls_tv);
        tv.setText(ssBean.getData().get(i).getName());

        return view;
    }
}
