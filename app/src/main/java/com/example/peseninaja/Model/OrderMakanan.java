package com.example.peseninaja.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class OrderMakanan implements Parcelable {
    private String name;
    private String price;

    protected OrderMakanan(Parcel in) {
        name = in.readString();
        price = in.readString();
    }

    public static final Creator<OrderMakanan> CREATOR = new Creator<OrderMakanan>() {
        @Override
        public OrderMakanan createFromParcel(Parcel in) {
            return new OrderMakanan(in);
        }

        @Override
        public OrderMakanan[] newArray(int size) {
            return new OrderMakanan[size];
        }
    };

    public OrderMakanan(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(price);
    }
}
