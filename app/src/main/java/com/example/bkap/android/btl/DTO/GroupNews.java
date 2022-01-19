package com.example.bkap.android.btl.DTO;

public class GroupNews {
    private int id;
    private String gHinhAnh;
    private String gTieuDe;
    private int gSoLuong;

    public GroupNews() {
    }

    public GroupNews(int id, String gHinhAnh, String gTieuDe, int gSoLuong) {
        this.id = id;
        this.gHinhAnh = gHinhAnh;
        this.gTieuDe = gTieuDe;
        this.gSoLuong = gSoLuong;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getgHinhAnh() {
        return gHinhAnh;
    }

    public void setgHinhAnh(String gHinhAnh) {
        this.gHinhAnh = gHinhAnh;
    }

    public String getgTieuDe() {
        return gTieuDe;
    }

    public void setgTieuDe(String gTieuDe) {
        this.gTieuDe = gTieuDe;
    }

    public int getgSoLuong() {
        return gSoLuong;
    }

    public void setgSoLuong(int gSoLuong) {
        this.gSoLuong = gSoLuong;
    }
}
