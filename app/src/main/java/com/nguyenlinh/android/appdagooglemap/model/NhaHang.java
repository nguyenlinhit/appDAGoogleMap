package com.nguyenlinh.android.appdagooglemap.model;

import android.graphics.Bitmap;
import java.io.Serializable;

/**
 * Created by nguye on 1/28/2017.
 */

public class NhaHang implements Serializable {
    private int ma;
    private String ten;
    private Bitmap hinh;
    private double vido;
    private double kinhdo;

    public NhaHang() {
    }
    public NhaHang(int ma, String ten, Bitmap hinh, double vido, double kinhdo) {
        this.ma = ma;
        this.ten = ten;
        this.hinh = hinh;
        this.vido = vido;
        this.kinhdo = kinhdo;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Bitmap getHinh() {
        return hinh;
    }

    public void setHinh(Bitmap hinh) {
        this.hinh = hinh;
    }

    public double getVido() {
        return vido;
    }

    public void setVido(double vido) {
        this.vido = vido;
    }

    public double getKinhdo() {
        return kinhdo;
    }

    public void setKinhdo(double kinhdo) {
        this.kinhdo = kinhdo;
    }

}
