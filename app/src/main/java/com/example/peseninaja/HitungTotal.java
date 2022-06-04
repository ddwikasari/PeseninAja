package com.example.peseninaja;

import com.example.peseninaja.Model.OrderDesert;
import com.example.peseninaja.Model.OrderKopi;
import com.example.peseninaja.Model.OrderMakanan;
import com.example.peseninaja.Model.OrderMinuman;
import com.example.peseninaja.Model.OrderSarapan;
import com.example.peseninaja.Model.OrderSnack;

import java.util.ArrayList;

public class HitungTotal {
    public int hitungTotalOrder(ArrayList<OrderMakanan> dataOrder){
        int total = 0;
        for(OrderMakanan order:dataOrder){
            total = total + Integer.parseInt(order.getPrice());
        }
        return total;
    }

    public int hitungTotalOrderMinuman(ArrayList<OrderMinuman> dataOrder){
        int total = 0;
        for(OrderMinuman order:dataOrder){
            total = total + Integer.parseInt(order.getPrice());
        }
        return total;
    }

    public int hitungTotalOrderSnack(ArrayList<OrderSnack> dataOrder){
        int total = 0;
        for(OrderSnack order:dataOrder){
            total = total + Integer.parseInt(order.getPrice());
        }
        return total;
    }

    public int hitungTotalOrderDesert(ArrayList<OrderDesert> dataOrder){
        int total = 0;
        for(OrderDesert order:dataOrder){
            total = total + Integer.parseInt(order.getPrice());
        }
        return total;
    }

    public int hitungTotalOrderKopi(ArrayList<OrderKopi> dataOrder){
        int total = 0;
        for(OrderKopi order:dataOrder){
            total = total + Integer.parseInt(order.getPrice());
        }
        return total;
    }

    public int hitungTotalOrderSarapan(ArrayList<OrderSarapan> dataOrder){
        int total = 0;
        for(OrderSarapan order:dataOrder){
            total = total + Integer.parseInt(order.getPrice());
        }
        return total;
    }
}
