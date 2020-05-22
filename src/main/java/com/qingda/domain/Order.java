package com.qingda.domain;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 参团的订单信息
 */
public class Order {


    private String l_ID;

    private String l_Theme;

    private String l_Destination;

    private String l_price;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String l_Data;

    private String l_Traffic;

    private String l_TravelDays;

    private String l_Participant;

    private String l_Explain;

    private String p_id;

    private String p_nameid;

    private int flag;

    public Order() {
    }

    public Order(int flag ,String l_ID, String l_Theme, String l_Destination, String l_price, String l_Data, String l_Traffic, String l_TravelDays, String l_Participant, String l_Explain, String p_id, String p_nameid) {
        this.l_ID = l_ID;
        this.l_Theme = l_Theme;
        this.l_Destination = l_Destination;
        this.l_price = l_price;
        this.l_Data = l_Data;
        this.l_Traffic = l_Traffic;
        this.l_TravelDays = l_TravelDays;
        this.l_Participant = l_Participant;
        this.l_Explain = l_Explain;
        this.p_id = p_id;
        this.p_nameid = p_nameid;
        this.flag = flag;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getL_ID() {
        return l_ID;
    }

    public void setL_ID(String l_ID) {
        this.l_ID = l_ID;
    }

    public String getL_Theme() {
        return l_Theme;
    }

    public void setL_Theme(String l_Theme) {
        this.l_Theme = l_Theme;
    }

    public String getL_Destination() {
        return l_Destination;
    }

    public void setL_Destination(String l_Destination) {
        this.l_Destination = l_Destination;
    }

    public String getL_price() {
        return l_price;
    }

    public void setL_price(String l_price) {
        this.l_price = l_price;
    }

    public String getL_Data() {
        return l_Data;
    }

    public void setL_Data(String l_Data) {
        this.l_Data = l_Data;
    }

    public String getL_Traffic() {
        return l_Traffic;
    }

    public void setL_Traffic(String l_Traffic) {
        this.l_Traffic = l_Traffic;
    }

    public String getL_TravelDays() {
        return l_TravelDays;
    }

    public void setL_TravelDays(String l_TravelDays) {
        this.l_TravelDays = l_TravelDays;
    }

    public String getL_Participant() {
        return l_Participant;
    }

    public void setL_Participant(String l_Participant) {
        this.l_Participant = l_Participant;
    }

    public String getL_Explain() {
        return l_Explain;
    }

    public void setL_Explain(String l_Explain) {
        this.l_Explain = l_Explain;
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

    @Override
    public String toString() {
        return "Order{" +
                "l_ID='" + l_ID + '\'' +
                ", l_Theme='" + l_Theme + '\'' +
                ", l_Destination='" + l_Destination + '\'' +
                ", l_price='" + l_price + '\'' +
                ", l_Data='" + l_Data + '\'' +
                ", l_Traffic='" + l_Traffic + '\'' +
                ", l_TravelDays='" + l_TravelDays + '\'' +
                ", l_Participant='" + l_Participant + '\'' +
                ", l_Explain='" + l_Explain + '\'' +
                ", p_id='" + p_id + '\'' +
                ", p_nameid='" + p_nameid + '\'' +
                '}';
    }
}
