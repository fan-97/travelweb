package com.qingda.domain;

import java.io.Serializable;

public class Participation implements Serializable {
    public Participation() {
    }

    public Participation(int flag, String p_nameid, String p_hoildayid, String price) {
        this.flag = flag;
        this.p_nameid = p_nameid;
        this.p_hoildayid = p_hoildayid;
        this.price = price;
    }

    private int flag;

    private String p_id;

    private String p_nameid;

    private String p_hoildayid;

    private String price;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getP_id() {
        return p_id;
    }

    public void setP_id(String p_id) {
        this.p_id = p_id;
    }

    public String getP_nameid() {
        return p_nameid;
    }

    public void setP_nameid(String p_nameid) {
        this.p_nameid = p_nameid;
    }

    public String getP_hoildayid() {
        return p_hoildayid;
    }

    public void setP_hoildayid(String p_hoildayid) {
        this.p_hoildayid = p_hoildayid;
    }

    @Override
    public String toString() {
        return "Participation{" +
          "p_id='" + p_id + '\'' +
          ", p_nameid='" + p_nameid + '\'' +
          ", p_hoildayid='" + p_hoildayid + '\'' +
          '}';
    }
}
