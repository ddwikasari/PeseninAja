package com.example.peseninaja.Seeder;

import com.example.peseninaja.KopiR;
import com.example.peseninaja.Model.Desert;
import com.example.peseninaja.Model.Kopi;
import com.example.peseninaja.R;

import java.util.ArrayList;

public class KopiData {
    private  static String [] kopiName = {
            "Nasi Kuning",
            "Nasi Goreng",
            "Sate",
            "Soto Betawi"
    };

    private static String [] kopiPrice = {
            "15000",
            "10000",
            "20000",
            "10000"
    };

    private static int[] kopiImage = {
            R.drawable.padang,
            R.drawable.nasgor,
            R.drawable.sate,
            R.drawable.soto,
    };

    public static ArrayList<Kopi> getListData(){
        ArrayList<Kopi> list = new ArrayList<>();
        for (int position = 0; position<kopiName.length; position++){
            Kopi kopi = new Kopi();
            kopi.setName(kopiName[position]);
            kopi.setPrice(kopiPrice[position]);
            kopi.setPhoto(kopiImage[position]);
            list.add(kopi);
        }
        return list;
    }
}
