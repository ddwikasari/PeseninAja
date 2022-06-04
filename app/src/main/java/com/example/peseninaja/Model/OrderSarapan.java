package com.example.peseninaja.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class OrderSarapan implements Parcelable {
    private String name;
    private String price;

    public OrderSarapan(Parcel in) {
        name = in.readString();
        price = in.readString();
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

    public static final Creator<OrderSarapan> CREATOR = new Creator<OrderSarapan>() {
        @Override
        public OrderSarapan createFromParcel(Parcel in) {
            return new OrderSarapan(in);
        }

        @Override
        public OrderSarapan[] newArray(int size) {
            return new OrderSarapan[size];
        }
    };

    public OrderSarapan(String name, String price) {
        this.name = name;
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
