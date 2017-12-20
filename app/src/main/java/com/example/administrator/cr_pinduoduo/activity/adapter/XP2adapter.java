package com.example.administrator.cr_pinduoduo.activity.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.cr_pinduoduo.R;
import com.example.administrator.cr_pinduoduo.activity.bean.Xp_xpbean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by Administrator on 2017/12/16.
 */

public class XP2adapter extends RecyclerView.Adapter<XP2adapter.My3ViewHolder> {

    Context context;
    Xp_xpbean xpXpbean;

    public XP2adapter(Context context,  Xp_xpbean xpXpbean) {
        this.context = context;
        this.xpXpbean = xpXpbean;
    }
    @Override
    public My3ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View   view=View.inflate(context,R.layout.xp_item2,null);
        My3ViewHolder   holder=new My3ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(My3ViewHolder holder, int position) {
        DraweeController  dc= Fresco.newDraweeControllerBuilder()
                .setUri(xpXpbean.getSku().get(position).getThumb_url())
                .setAutoPlayAnimations(true)
                .build();
        holder.iv.setController(dc);

    }

    @Override
    public int getItemCount() {
        return xpXpbean.getSku().size();
    }


    class My3ViewHolder extends RecyclerView.ViewHolder {
        private final SimpleDraweeView iv;

        public My3ViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.xp_xpimg2);


        }

    }


}
