package com.example.administrator.cr_pinduoduo.activity.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.cr_pinduoduo.R;
import com.example.administrator.cr_pinduoduo.activity.bean.GgBean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by Administrator on 2017/12/13.
 */

public class Gjgg_Padapter extends RecyclerView.Adapter<Gjgg_Padapter.MyViewHolder> {

    Context context;
    GgBean ggBean;
    OnItemClickLinstener listener;


    public Gjgg_Padapter(Context context, GgBean ggBean) {
        this.context = context;
        this.ggBean = ggBean;
    }

    //获取方法的传参值
    public void setOnItemClickLinstener(OnItemClickLinstener listener) {
        //指定当前的值
        this.listener = listener;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = View.inflate(context, R.layout.jdgg_rv_item, null);
        MyViewHolder holder = new MyViewHolder(view);
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

        holder.tv.setText(ggBean.getList().get(position).getGoods_name()+"");

        holder.tv3.setText("￥" +ggBean.getList().get(position).getMarket_price() + "");

        DraweeController dc = Fresco.newDraweeControllerBuilder()
                .setUri(ggBean.getList().get(position).getThumb_url())
                .setAutoPlayAnimations(true)
                .build();
        holder.iv.setController(dc);
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return ggBean.getList().size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView iv;
        private final TextView tv,tv3;

        public MyViewHolder(View itemView) {
            super(itemView);
            iv = (SimpleDraweeView) itemView.findViewById(R.id.gg_img);
            tv = (TextView) itemView.findViewById(R.id.gg_desc);
            tv3 = (TextView) itemView.findViewById(R.id.gg_price);


        }

    }

    //创建接口
    public interface OnItemClickLinstener {
        //创建接口的方法
        public void OnItemClick(View view, int position);
    }


}
