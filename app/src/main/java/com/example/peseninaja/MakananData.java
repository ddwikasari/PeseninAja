package com.example.peseninaja;

import java.util.ArrayList;

public class MakananData {
    private static String [] makananName = {
            "Nasi Goreng",
            "Mie Goreng",
            "Kwetiau Goreng",
            "Ayam Goreng",
            "Nasi Pecel"
    };

    private static int [] makananPrice = {
            15000,
            25000,
            20000,
            10000,
            7000
    };

    private static int[] makananImage = {
            R.drawable.nasgor,
            R.drawable.padang,
            R.drawable.soto,
            R.drawable.sate,
            R.drawable.gado
    };

    static ArrayList<Makanan> getListData(){
        ArrayList<Makanan> list = new ArrayList<>();
        for (int position = 0; position <makananName.length; position++){
            Makanan makanan = new Makanan();
            makanan.setName(makananName[position]);
            makanan.setPrice(makananPrice[position]);
            makanan.setPhoto(makananImage[position]);
            list.add(makanan);
        }
        return list;
    }

}
