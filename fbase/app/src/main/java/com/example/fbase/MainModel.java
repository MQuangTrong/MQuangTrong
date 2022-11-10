package com.example.fbase;

public class MainModel {

    String ten, tuoi, anh;

    MainModel(){

    }

    public MainModel(String ten, String tinhtrang, String anh) {
        this.ten = ten;
        this.tuoi = tinhtrang;
        this.anh = anh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTuoi() {
        return tuoi;
    }

    public void setTuoi(String tuoi) {
        this.tuoi = tuoi;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

}
