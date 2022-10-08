package com.example.bt_giuaky;

public class Chitiet_dv {
    private String ten;
    private int anh;
    private String mota;
    private String tinhtrang;

    public Chitiet_dv(String ten, int anh, String mota, String tinhtrang) {
        this.ten = ten;
        this.anh = anh;
        this.mota = mota;
        this.tinhtrang = tinhtrang;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getAnh() {
        return anh;
    }

    public void setAnh(int anh) {
        this.anh = anh;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(String tinhtrang) {
        this.tinhtrang = tinhtrang;
    }
}
