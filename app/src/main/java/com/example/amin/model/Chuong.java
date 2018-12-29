package com.example.amin.model;

import java.io.Serializable;

/**
 * Created by hungv on 3/31/2017.
 */

public class Chuong implements Serializable {
    String chuong;
    String tenChuong;
    String noiDung;
    String xauTimKiem;

    public String getXauTimKiem() {
        return xauTimKiem;
    }

    public void setXauTimKiem(String xauTimKiem) {
        this.xauTimKiem = xauTimKiem;
    }

    public String getTenChuong() {
        return tenChuong;
    }

    public void setTenChuong(String tenChuong) {
        this.tenChuong = tenChuong;
    }

    public String getChuong() {
        return chuong;
    }

    public void setChuong(String chuong) {
        this.chuong = chuong;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

}
