package com.example.administrator.cr_pinduoduo.activity.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.cr_pinduoduo.R;
import com.example.administrator.cr_pinduoduo.activity.bean.Sppjbean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/12/13.
 */

public class XP_pjadapter extends RecyclerView.Adapter<XP_pjadapter.MyViewHolder> {

    Context context;
    Sppjbean sppjbean;
    OnItemClickLinstener listener;
    @BindView(R.id.pj_img)
    SimpleDraweeView pjImg;
    @BindView(R.id.pj_tv)
    TextView pjTv;
    @BindView(R.id.pj_time)
    TextView pjTime;
    @BindView(R.id.pj_tv2)
    TextView pjTv2;

    public XP_pjadapter(Context context, Sppjbean sppjbean) {
        this.context = context;
        this.sppjbean = sppjbean;
    }

    //获取方法的传参值
    public void setOnItemClickLinstener(OnItemClickLinstener listener) {
        //指定当前的值
        this.listener = listener;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = View.inflate(context, R.layout.sp_pj_item, null);
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

        holder.tv.setText(sppjbean.getData().get(position).getName());
        holder.tv2.setText(sppjbean.getData().get(position).getComment());
        DraweeController dc = Fresco.newDraweeControllerBuilder()
                .setUri(sppjbean.getData().get(position).getAvatar())
                .setAutoPlayAnimations(true)
                .build();
        holder.iv.setController(dc);
        holder.time.setText(sppjbean.getData().get(position).getTime()+"");
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return sppjbean.getData().size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView iv;
        private final TextView tv, tv2,time;

        public MyViewHolder(View itemView) {
            super(itemView);
            iv = (SimpleDraweeView) itemView.findViewById(R.id.pj_img);
            tv = (TextView) itemView.findViewById(R.id.pj_tv);
            tv2 = (TextView) itemView.findViewById(R.id.pj_tv2);
            time = (TextView) itemView.findViewById(R.id.pj_time);

        }

    }

    //创建接口
    public interface OnItemClickLinstener {
        //创建接口的方法
        public void OnItemClick(View view, int position);
    }


}
