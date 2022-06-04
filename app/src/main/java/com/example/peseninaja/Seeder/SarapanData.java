package com.example.peseninaja.Seeder;

import com.example.peseninaja.Model.Kopi;
import com.example.peseninaja.Model.Sarapan;
import com.example.peseninaja.R;

import java.util.ArrayList;

public class SarapanData {
    private  static String [] sarapanName = {
            "Nasi Kuning",
            "Nasi Goreng",
            "Sate",
            "Soto Betawi"
    };

    private static String [] sarapanPrice = {
            "15000",
            "10000",
            "20000",
            "10000"
    };

    private static int[] sarapanImage = {
            R.drawable.padang,
            R.drawable.nasgor,
            R.drawable.sate,
            R.drawable.soto,
    };

    public static ArrayList<Sarapan> getListData(){
        ArrayList<Sarapan> list = new ArrayList<>();
        for (int position = 0; position<sarapanName.length; position++){
            Sarapan sarapan = new Sarapan();
            sarapan.setName(sarapanName[position]);
            sarapan.setPrice(sarapanPrice[position]);
            sarapan.setPhoto(sarapanImage[position]);
            list.add(sarapan);
        }
        return list;
    }
}
