package com.example.administrator.cr_pinduoduo.activity.bean;

/**
 * Created by Administrator on 2017/12/18.
 */

public class EbsBean {
    private   String   cid;

    public String getCid() {

        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public EbsBean(String cid) {

        this.cid = cid;
    }

    @Override
    public String toString() {
        return "EbsBean{" +
                "cid=" + cid +
                '}';
    }
}
