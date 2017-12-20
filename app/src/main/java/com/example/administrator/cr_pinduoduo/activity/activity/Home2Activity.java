package com.example.administrator.cr_pinduoduo.activity.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.administrator.cr_pinduoduo.R;
import com.example.administrator.cr_pinduoduo.activity.NewActivity;
import com.zhy.autolayout.AutoLayoutActivity;

public class Home2Activity extends AutoLayoutActivity {

    int reclen=1;
    Handler handler=new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                reclen--;
                if(reclen<0){

                    Intent intent=new Intent(Home2Activity.this,NewActivity.class);
                    startActivity(intent);
                    finish();
                    return;

                }
                handler.postDelayed(this,500);

            }
        },1000) ;

    }
}
