package com.example.peseninaja;

import android.os.Parcel;
import android.os.Parcelable;

public class Makanan {
    private String nama;
    private int price, image;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
