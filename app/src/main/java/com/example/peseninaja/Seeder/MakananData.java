package com.example.peseninaja.Seeder;
import com.example.peseninaja.Model.Makanan;
import com.example.peseninaja.R;

import java.util.ArrayList;

public class MakananData {
    private  static String [] makananName = {
            "Nasi Kuning",
            "Nasi Goreng",
            "Sate",
            "Soto Betawi"
    };

    private static String [] makananPrice= {
            "15000",
            "10000",
            "20000",
            "10000"
    };

    private static int[] makananImage = {
            R.drawable.padang,
            R.drawable.nasgor,
            R.drawable.sate,
            R.drawable.soto,
    };

    public static ArrayList<Makanan> getListData(){
        ArrayList<Makanan> list = new ArrayList<>();
        for (int position = 0; position<makananName.length; position++){
            Makanan makanan = new Makanan();
            makanan.setName(makananName[position]);
            makanan.setPrice(makananPrice[position]);
            makanan.setPhoto(makananImage[position]);
            list.add(makanan);
        }
        return list;
    }
}
