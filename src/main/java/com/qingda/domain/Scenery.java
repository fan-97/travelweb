package com.qingda.domain;

import java.io.Serializable;

public class Scenery implements Serializable {

    private String c_ID;

    private String c_Name;

    private String c_Genus_prov;

    private String c_Genus_city;

    private String c_Genus_coun;

    private String c_Level;

    private String c_Type;

    private String c_Fit;

    private String c_Price;

    private String c_Introduction;

    private String c_Photo;

    public String getC_ID() {
        return c_ID;
    }

    public void setC_ID(String c_ID) {
        this.c_ID = c_ID;
    }

    public String getC_Name() {
        return c_Name;
    }

    public void setC_Name(String c_Name) {
        this.c_Name = c_Name;
    }

    public String getC_Genus_prov() {
        return c_Genus_prov;
    }

    public void setC_Genus_prov(String c_Genus_prov) {
        this.c_Genus_prov = c_Genus_prov;
    }

    public String getC_Genus_city() {
        return c_Genus_city;
    }

    public void setC_Genus_city(String c_Genus_city) {
        this.c_Genus_city = c_Genus_city;
    }

    public String getC_Genus_coun() {
        return c_Genus_coun;
    }

    public void setC_Genus_coun(String c_Genus_coun) {
        this.c_Genus_coun = c_Genus_coun;
    }

    public String getC_Level() {
        return c_Level;
    }

    public void setC_Level(String c_Level) {
        this.c_Level = c_Level;
    }

    public String getC_Type() {
        return c_Type;
    }

    public void setC_Type(String c_Type) {
        this.c_Type = c_Type;
    }

    public String getC_Fit() {
        return c_Fit;
    }

    public void setC_Fit(String c_Fit) {
        this.c_Fit = c_Fit;
    }

    public String getC_Price() {
        return c_Price;
    }

    public void setC_Price(String c_Price) {
        this.c_Price = c_Price;
    }

    public String getC_Introduction() {
        return c_Introduction;
    }

    public void setC_Introduction(String c_Introduction) {
        this.c_Introduction = c_Introduction;
    }

    public String getC_Photo() {
        return c_Photo;
    }

    public void setC_Photo(String c_Photo) {
        this.c_Photo = c_Photo;
    }

    @Override
    public String toString() {
        return "Scenery{" +
          "c_ID='" + c_ID + '\'' +
          ", c_Name='" + c_Name + '\'' +
          ", c_Genus_prov='" + c_Genus_prov + '\'' +
          ", c_Genus_city='" + c_Genus_city + '\'' +
          ", c_Genus_coun='" + c_Genus_coun + '\'' +
          ", c_Level='" + c_Level + '\'' +
          ", c_Type='" + c_Type + '\'' +
          ", c_Fit='" + c_Fit + '\'' +
          ", c_Price='" + c_Price + '\'' +
          ", c_Introduction='" + c_Introduction + '\'' +
          ", c_Photo='" + c_Photo + '\'' +
          '}';
    }
}
