package com.example.administrator.cr_pinduoduo.activity.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.cr_pinduoduo.R;
import com.example.administrator.cr_pinduoduo.activity.bean.FlyBean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by Administrator on 2017/12/16.
 */

public class Ssyyadapter extends RecyclerView.Adapter<Ssyyadapter.MyViewHolder>{

    Context context;
    FlyBean flyBean;

    public Ssyyadapter(Context context,FlyBean flyBean) {
        this.context = context;
        this.flyBean = flyBean;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View   view=View.inflate(context,R.layout.ss_rv_item,null);
       MyViewHolder   holder=new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

       // for(int i=0;i<flyBean.getData().size();i++)
        //{
            holder.tv.setText(flyBean.getData().get(0).getList().get(position).getName());

            DraweeController dc= Fresco.newDraweeControllerBuilder()
                    .setUri(flyBean.getData().get(0).getList().get(position).getIcon())
                    .setAutoPlayAnimations(true)
                    .build();
            holder.iv.setController(dc);

       // }


    }

    @Override
    public int getItemCount() {
        for(int j=0;j<flyBean.getData().size();j++)
        {
            return flyBean.getData().get(j).getList().size();
        }
      return 0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView iv;
        private final TextView tv;

        public MyViewHolder(View itemView) {
            super(itemView);
            iv = (SimpleDraweeView) itemView.findViewById(R.id.ss_rv_img);
            tv = (TextView) itemView.findViewById(R.id.ss_rv_tv);

        }


    }

}
