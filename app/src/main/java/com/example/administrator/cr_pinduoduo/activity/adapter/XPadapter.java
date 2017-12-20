package com.example.administrator.cr_pinduoduo.activity.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.cr_pinduoduo.R;
import com.example.administrator.cr_pinduoduo.activity.bean.XPbean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by Administrator on 2017/12/13.
 */

public class XPadapter extends RecyclerView.Adapter<XPadapter.MyViewHolder> {

    Context context;
    XPbean   xPbean;
    OnItemClickLinstener   listener;

    public XPadapter(Context context, XPbean xPbean) {
        this.context = context;
        this.xPbean = xPbean;
    }

    //获取方法的传参值
    public void setOnItemClickLinstener(OnItemClickLinstener listener) {
        //指定当前的值
        this.listener = listener;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View   view=View.inflate(context,R.layout.xp_item,null);
        MyViewHolder   holder=new MyViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //实例化listener来调用接口的方法    强转类型
                listener.OnItemClick(view, (int) view.getTag());
            }
        });
        return holder;

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.tv.setText(xPbean.getGoods_list().get(position).getGoods_name());
        holder.tv2.setText("￥"+xPbean.getGoods_list().get(position).getMarket_price()+"");
        DraweeController dc= Fresco.newDraweeControllerBuilder()
                .setUri(xPbean.getGoods_list().get(position).getImage_url())
                .setAutoPlayAnimations(true)
                .build();
        holder.iv.setController(dc);
        holder.itemView.setTag(position);

    }

    @Override
    public int getItemCount() {
        return xPbean.getGoods_list().size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView iv;
        private final TextView tv,tv2;

        public MyViewHolder(View itemView) {
            super(itemView);
            iv = (SimpleDraweeView) itemView.findViewById(R.id.xprv_img);
            tv = (TextView) itemView.findViewById(R.id.xprv_tv);
            tv2 = (TextView) itemView.findViewById(R.id.xprv_privce);

        }

    }

    //创建接口
    public  interface OnItemClickLinstener{
        //创建接口的方法
        public void OnItemClick(View view,int position);
    }




}
