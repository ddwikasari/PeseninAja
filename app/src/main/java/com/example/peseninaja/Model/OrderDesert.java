package com.example.peseninaja.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class OrderDesert implements Parcelable {

    private String name;
    private String price;

    public OrderDesert(Parcel in) {
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

    public static final Creator<OrderDesert> CREATOR = new Creator<OrderDesert>() {
        @Override
        public OrderDesert createFromParcel(Parcel in) {
            return new OrderDesert(in);
        }

        @Override
        public OrderDesert[] newArray(int size) {
            return new OrderDesert[size];
        }
    };

    public OrderDesert(String name, String price) {
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
