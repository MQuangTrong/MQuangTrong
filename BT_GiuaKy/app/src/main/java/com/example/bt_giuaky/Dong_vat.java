package com.example.bt_giuaky;

public class Dong_vat {
    private String ten;
    private String moTa;
    private int hinh;

    public Dong_vat(String ten, String moTa, int hinh) {
        this.ten = ten;
        this.moTa = moTa;
        this.hinh = hinh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }
}
