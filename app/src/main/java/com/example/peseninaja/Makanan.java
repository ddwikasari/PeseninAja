package com.example.peseninaja;

import android.os.Parcel;
import android.os.Parcelable;

public class Makanan implements Parcelable {

    private String Title;
    private int Price;
    private int Photo;

    public Makanan() {
    }

    public Makanan(String title, int price, int photo) {
        Title = title;
        Price = price;
        Photo = photo;
    }

    protected Makanan(Parcel in) {
        Title = in.readString();
        Price = in.readInt();
        Photo = in.readInt();
    }

    public static final Creator<Makanan> CREATOR = new Creator<Makanan>() {
        @Override
        public Makanan createFromParcel(Parcel in) {
            return new Makanan(in);
        }

        @Override
        public Makanan[] newArray(int size) {
            return new Makanan[size];
        }
    };

    public String getTitle() {
        return Title;
    }

    public int getPrice() {
        return Price;
    }

    public int getPhoto() {
        return Photo;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public void setPhoto(int photo) {
        Photo = photo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(Title);
        parcel.writeInt(Price);
        parcel.writeInt(Photo);
    }
}
