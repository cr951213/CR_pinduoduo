package com.example.administrator.cr_pinduoduo.activity.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.cr_pinduoduo.R;
import com.example.administrator.cr_pinduoduo.activity.activity.XP_xqActivity;
import com.example.administrator.cr_pinduoduo.activity.bean.XPbean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/12/16.
 */

public class Syrv2_adapter extends RecyclerView.Adapter<Syrv2_adapter.My3ViewHolder> {

    Context context;
    XPbean xPbean;

    @BindView(R.id.but_pd)
    Button butPd;

    public Syrv2_adapter(Context context, XPbean xPbean) {
        this.context = context;
        this.xPbean = xPbean;
    }



    @Override
    public My3ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.syrv2__item, null);
        My3ViewHolder holder = new My3ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(My3ViewHolder holder, int position) {

        holder.tv1.setText(xPbean.getGoods_list().get(position).getShort_name());
        holder.tv2.setText("￥" + xPbean.getGoods_list().get(position).getMarket_price() + "");

        DraweeController dc = Fresco.newDraweeControllerBuilder()
                .setUri(xPbean.getGoods_list().get(position).getThumb_url())
                .setAutoPlayAnimations(true)
                .build();
        holder.iv.setController(dc);

        holder.but_pd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"准备跳转到详情页面！！！",Toast.LENGTH_SHORT).show();

                Intent intent2=new Intent(context, XP_xqActivity.class);
                for(int i=0;i<xPbean.getGoods_list().size();i++)
                {
                    intent2.putExtra("gid",xPbean.getGoods_list().get(i).getGoods_id());
                    intent2.putExtra("mid",xPbean.getGoods_list().get(i).getMall_id());

                }
               //Log.i("===========",xPbean.getGoods_list().get(position).getGoods_id()+"");
               context.startActivity(intent2);


            }
        });

    }

    @Override
    public int getItemCount() {
        return xPbean.getGoods_list().size();
    }

    @OnClick(R.id.but_pd)
    public void onViewClicked() {
    }


    class My3ViewHolder extends RecyclerView.ViewHolder {
        private final SimpleDraweeView iv;
        private final TextView tv1, tv2;
        private final   Button  but_pd;

        public My3ViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.syrv_img);
            tv1 = itemView.findViewById(R.id.syrv_name);
            tv2 = itemView.findViewById(R.id.syrv_price);
            but_pd=itemView.findViewById(R.id.but_pd);


        }

    }


}
