package com.example.peseninaja.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class OrderMinuman implements Parcelable {
    private String name;
    private String price;

    public OrderMinuman(Parcel in) {
        name = in.readString();
        price = in.readString();
    }

    public OrderMinuman(String name, String price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(price);
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

    public static final Creator<OrderMinuman> CREATOR = new Creator<OrderMinuman>() {
        @Override
        public OrderMinuman createFromParcel(Parcel in) {
            return new OrderMinuman(in);
        }

        @Override
        public OrderMinuman[] newArray(int size) {
            return new OrderMinuman[size];
        }
    };
}
