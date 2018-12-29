package com.example.amin.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by hungv on 3/25/2017.
 */

public class Truyen implements Serializable {
    String ten;
    String soChuong;
    ArrayList<Chuong> dsChuong;
    byte[] img;
    int yeuThich;
    String theLoai;
    String tomTat;

    public String getTomTat() {
        return tomTat;
    }

    public void setTomTat(String tomTat) {
        this.tomTat = tomTat;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public int getYeuThich() {
        return yeuThich;
    }

    public void setYeuThich(int yeuThich) {
        this.yeuThich = yeuThich;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSoChuong() {
        return soChuong;
    }

    public void setSoChuong(String soChuong) {
        this.soChuong = soChuong;
    }

    public ArrayList<Chuong> getDsChuong() {
        return dsChuong;
    }

    public void setDsChuong(ArrayList<Chuong> dsChuong) {
        this.dsChuong = dsChuong;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }
}
