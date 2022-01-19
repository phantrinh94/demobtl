package com.example.bkap.android.btl.DTO;

public class TinTuc {
    private int mId;
    private String mNguoiDang;
    private String mSDT;
    private String mNoiDung;
    private String mDiaChi;

    public TinTuc() {
    }

    public TinTuc(String mNguoiDang, String mSDT, String mNoiDung, String mDiaChi) {
        this.mNguoiDang = mNguoiDang;
        this.mSDT = mSDT;
        this.mNoiDung = mNoiDung;
        this.mDiaChi = mDiaChi;
    }

    public TinTuc(int mId, String mNguoiDang, String mSDT, String mNoiDung, String mDiaChi) {
        this.mId = mId;
        this.mNguoiDang = mNguoiDang;
        this.mSDT = mSDT;
        this.mNoiDung = mNoiDung;
        this.mDiaChi = mDiaChi;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmNguoiDang() {
        return mNguoiDang;
    }

    public void setmNguoiDang(String mNguoiDang) {
        this.mNguoiDang = mNguoiDang;
    }

    public String getmSDT() {
        return mSDT;
    }

    public void setmSDT(String mSDT) {
        this.mSDT = mSDT;
    }

    public String getmNoiDung() {
        return mNoiDung;
    }

    public void setmNoiDung(String mNoiDung) {
        this.mNoiDung = mNoiDung;
    }

    public String getmDiaChi() {
        return mDiaChi;
    }

    public void setmDiaChi(String mDiaChi) {
        this.mDiaChi = mDiaChi;
    }
}
