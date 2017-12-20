package com.example.administrator.cr_pinduoduo.activity.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.cr_pinduoduo.R;
import com.example.administrator.cr_pinduoduo.activity.bean.OneBean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by Administrator on 2017/12/16.
 */

public class Two_adapter extends RecyclerView.Adapter<Two_adapter.MyViewHolder>{

    Context context;
    OneBean oneBean;

    public Two_adapter(Context context, OneBean oneBean) {
        this.context = context;
        this.oneBean = oneBean;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View   view=View.inflate(context,R.layout.two_item,null);
       MyViewHolder   holder=new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {



                holder.tv.setText(oneBean.getData().get(10+position).getName());

                DraweeController dc= Fresco.newDraweeControllerBuilder()
                        .setUri(oneBean.getData().get(10+position).getIcon())
                        .setAutoPlayAnimations(true)
                        .build();
                holder.iv.setController(dc);





      /*  holder.tv.setText(oneBean.getData().get(position+10).getName());

        DraweeController dc= Fresco.newDraweeControllerBuilder()
                .setUri(oneBean.getData().get(position+10).getIcon())
                .setAutoPlayAnimations(true)
                .build();
        holder.iv.setController(dc);*/



    }

    @Override
    public int getItemCount() {

       return 9;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView iv;
        private final TextView tv;

        public MyViewHolder(View itemView) {
            super(itemView);
            iv = (SimpleDraweeView) itemView.findViewById(R.id.two_rv_img);
            tv = (TextView) itemView.findViewById(R.id.two_rv_tv);

        }


    }

}
