package com.qingda.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;

public class User implements Serializable {

    private String u_ID;

    private String u_Name;

    private String u_Password;

    private String u_Sex;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String u_Birth;

    private String u_Location_prov;

    private String u_Location_city;

    private String u_Location_coun;

    private String u_DocumentType;

    private String u_IDNumber;

    private String role;
    private BigDecimal u_price;

    public BigDecimal getU_price() {
        return u_price;
    }

    public void setU_price(BigDecimal u_price) {
        this.u_price = u_price;
    }

    @Override
    public String toString() {
        return "User{" +
                "u_ID='" + u_ID + '\'' +
                ", u_Name='" + u_Name + '\'' +
                ", u_Password='" + u_Password + '\'' +
                ", u_Sex='" + u_Sex + '\'' +
                ", u_Birth='" + u_Birth + '\'' +
                ", u_Location_prov='" + u_Location_prov + '\'' +
                ", u_Location_city='" + u_Location_city + '\'' +
                ", u_Location_coun='" + u_Location_coun + '\'' +
                ", u_DocumentType='" + u_DocumentType + '\'' +
                ", u_IDNumber='" + u_IDNumber + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public String getU_ID() {
        return u_ID;
    }

    public void setU_ID(String u_ID) {
        this.u_ID = u_ID;
    }

    public String getU_Name() {
        return u_Name;
    }

    public void setU_Name(String u_Name) {
        this.u_Name = u_Name;
    }

    public String getU_Password() {
        return u_Password;
    }

    public void setU_Password(String u_Password) {
        this.u_Password = u_Password;
    }

    public String getU_Sex() {
        return u_Sex;
    }

    public void setU_Sex(String u_Sex) {
        this.u_Sex = u_Sex;
    }

    public String getU_Birth() {
        return u_Birth;
    }

    public void setU_Birth(String u_Birth) {
        this.u_Birth = u_Birth;
    }

    public String getU_Location_prov() {
        return u_Location_prov;
    }

    public void setU_Location_prov(String u_Location_prov) {
        this.u_Location_prov = u_Location_prov;
    }

    public String getU_Location_city() {
        return u_Location_city;
    }

    public void setU_Location_city(String u_Location_city) {
        this.u_Location_city = u_Location_city;
    }

    public String getU_Location_coun() {
        return u_Location_coun;
    }

    public void setU_Location_coun(String u_Location_coun) {
        this.u_Location_coun = u_Location_coun;
    }

    public String getU_DocumentType() {
        return u_DocumentType;
    }

    public void setU_DocumentType(String u_DocumentType) {
        this.u_DocumentType = u_DocumentType;
    }

    public String getU_IDNumber() {
        return u_IDNumber;
    }

    public void setU_IDNumber(String u_IDNumber) {
        this.u_IDNumber = u_IDNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
