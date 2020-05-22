package com.qingda.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

public class Holiday implements Serializable {
    private String l_ID;

    private String l_Theme;

    private String l_Destination;

    private String l_RetailPrice;

    private String l_ChildPrice;

    private String l_StudentPrice;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String l_Data;

    private String l_Traffic;

    private String l_TravelDays;

    private String l_Participant;

    private String l_Explain;

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

    public String getL_RetailPrice() {
        return l_RetailPrice;
    }

    public void setL_RetailPrice(String l_RetailPrice) {
        this.l_RetailPrice = l_RetailPrice;
    }

    public String getL_ChildPrice() {
        return l_ChildPrice;
    }

    public void setL_ChildPrice(String l_ChildPrice) {
        this.l_ChildPrice = l_ChildPrice;
    }

    public String getL_StudentPrice() {
        return l_StudentPrice;
    }

    public void setL_StudentPrice(String l_StudentPrice) {
        this.l_StudentPrice = l_StudentPrice;
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

    @Override
    public String toString() {
        return "Holiday{" +
          "l_ID='" + l_ID + '\'' +
          ", l_Theme='" + l_Theme + '\'' +
          ", l_Destination='" + l_Destination + '\'' +
          ", l_RetailPrice='" + l_RetailPrice + '\'' +
          ", l_ChildPrice='" + l_ChildPrice + '\'' +
          ", l_StudentPrice='" + l_StudentPrice + '\'' +
          ", l_Data='" + l_Data + '\'' +
          ", l_Traffic='" + l_Traffic + '\'' +
          ", l_TravelDays='" + l_TravelDays + '\'' +
          ", l_Participant='" + l_Participant + '\'' +
          ", l_Explain='" + l_Explain + '\'' +
          '}';
    }
}
