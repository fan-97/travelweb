package com.qingda.domain;

import java.io.Serializable;

public class Participation implements Serializable {

    private String p_id;

    private String p_nameid;

    private String p_hoildayid;

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
