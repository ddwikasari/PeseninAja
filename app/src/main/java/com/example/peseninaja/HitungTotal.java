package com.example.peseninaja;

import com.example.peseninaja.Model.OrderMakanan;

import java.util.ArrayList;

public class HitungTotal {
    public int hitungTotalOrder(ArrayList<OrderMakanan> dataOrder){
        int total = 0;
        for(OrderMakanan order:dataOrder){
            total = total + Integer.parseInt(order.getPrice());
        }
        return total;
    }

}
