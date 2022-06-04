package com.example.peseninaja.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class OrderSnack implements Parcelable {
    private String name;
    private String price;

    protected OrderSnack(Parcel in) {
        name = in.readString();
        price = in.readString();
    }

    public OrderSnack(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public static final Creator<OrderSnack> CREATOR = new Creator<OrderSnack>() {
        @Override
        public OrderSnack createFromParcel(Parcel in) {
            return new OrderSnack(in);
        }

        @Override
        public OrderSnack[] newArray(int size) {
            return new OrderSnack[size];
        }
    };

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
