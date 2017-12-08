package com.example.miracle_.note.Model;


import java.util.Date;

/**
 * Created by MIRACLE- on 03/12/2017.
 */

public class Ghichu {
    private int mID;
    private String mTieude;
    private String mNoidung;
    private String mNgay;
    private String mGio;

    public Ghichu(String mTieude, String mNoidung, String mNgay, String mGio) {
        this.mTieude = mTieude;
        this.mNoidung = mNoidung;
        this.mNgay = mNgay;
        this.mGio = mGio;
    }

    public Ghichu(int mID, String mTieude, String mNoidung, String mNgay, String mGio) {
        this.mID = mID;
        this.mTieude = mTieude;
        this.mNoidung = mNoidung;
        this.mNgay = mNgay;
        this.mGio = mGio;
    }

    public int getmID() {
        return mID;
    }

    public void setmID(int mID) {
        this.mID = mID;
    }

    public String getmTieude() {
        return mTieude;
    }

    public void setmTieude(String mTieude) {
        this.mTieude = mTieude;
    }

    public String getmNoidung() {
        return mNoidung;
    }

    public void setmNoidung(String mNoidung) {
        this.mNoidung = mNoidung;
    }

    public String getmNgay() {
        return mNgay;
    }

    public void setmNgay(String mNgay) {
        this.mNgay = mNgay;
    }

    public String getmGio() {
        return mGio;
    }

    public void setmGio(String mGio) {
        this.mGio = mGio;
    }
}
