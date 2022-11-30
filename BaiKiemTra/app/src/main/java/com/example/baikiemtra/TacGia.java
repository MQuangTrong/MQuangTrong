package com.example.baikiemtra;

public class TacGia {
    private int hinhAnh;
    private  String ten;
    private  String moTa;
    private  String quocGia;
    private  String soSao;

    public TacGia() {
    }

    public TacGia(int hinhAnh, String ten, String moTa, String quocGia, String soSao) {
        this.hinhAnh = hinhAnh;
        this.ten = ten;
        this.moTa = moTa;
        this.quocGia = quocGia;
        this.soSao = soSao;
    }

    public int getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(int hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNgheDanh() {
        return moTa;
    }

    public void setNgheDanh(String moTa) {
        this.moTa = moTa;
    }

    public String getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(String quocGia) {
        this.quocGia = quocGia;
    }

    public String getSoSao() {
        return soSao;
    }

    public void setSoSao(String soSao) {
        this.soSao = soSao;
    }
}
