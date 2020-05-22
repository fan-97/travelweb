package com.qingda.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

public class News implements Serializable{

    private String n_ID;

    private String n_MainTitle;

    private String n_Author;

    private String n_Category;

    private String n_Content;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String n_Datetime;

    public String getN_ID() {
        return n_ID;
    }

    public void setN_ID(String n_ID) {
        this.n_ID = n_ID;
    }

    public String getN_MainTitle() {
        return n_MainTitle;
    }

    public void setN_MainTitle(String n_MainTitle) {
        this.n_MainTitle = n_MainTitle;
    }

    public String getN_Author() {
        return n_Author;
    }

    public void setN_Author(String n_Author) {
        this.n_Author = n_Author;
    }

    public String getN_Category() {
        return n_Category;
    }

    public void setN_Category(String n_Category) {
        this.n_Category = n_Category;
    }

    public String getN_Content() {
        return n_Content;
    }

    public void setN_Content(String n_Content) {
        this.n_Content = n_Content;
    }

    public String getN_Datetime() {
        return n_Datetime;
    }

    public void setN_Datetime(String n_Datetime) {
        this.n_Datetime = n_Datetime;
    }

    @Override
    public String toString() {
        return "News{" +
          "n_ID='" + n_ID + '\'' +
          ", n_MainTitle='" + n_MainTitle + '\'' +
          ", n_Author='" + n_Author + '\'' +
          ", n_Category='" + n_Category + '\'' +
          ", n_Content='" + n_Content + '\'' +
          ", n_Datetime='" + n_Datetime + '\'' +
          '}';
    }
}
