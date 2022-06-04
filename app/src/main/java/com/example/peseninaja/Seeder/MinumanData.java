package com.example.peseninaja.Seeder;

import com.example.peseninaja.Model.Makanan;
import com.example.peseninaja.Model.Minuman;
import com.example.peseninaja.R;

import java.util.ArrayList;

public class MinumanData {
    private  static String [] minumanName = {
            "Nasi Kuning",
            "Nasi Goreng",
            "Sate",
            "Soto Betawi"
    };

    private static String [] minumanPrice = {
            "15000",
            "10000",
            "20000",
            "10000"
    };

    private static int[] minumanImage = {
            R.drawable.padang,
            R.drawable.nasgor,
            R.drawable.sate,
            R.drawable.soto,
    };

    public static ArrayList<Minuman> getListData(){
        ArrayList<Minuman> list = new ArrayList<>();
        for (int position = 0; position<minumanName.length; position++){
            Minuman minuman = new Minuman();
            minuman.setName(minumanName[position]);
            minuman.setPrice(minumanPrice[position]);
            minuman.setPhoto(minumanImage[position]);
            list.add(minuman);
        }
        return list;
    }
}
