package com.example.bt_cuoiky;

public class DongVatModel {
    String ten, tinhtrang, anh, mota;

    DongVatModel(){

    }

    public DongVatModel(String ten, String tinhtrang, String anh, String mota) {
        this.ten = ten;
        this.tinhtrang = tinhtrang;
        this.anh = anh;
        this.mota = mota;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(String tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
}
