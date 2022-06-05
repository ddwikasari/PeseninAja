package com.example.peseninaja.Seeder;
import com.example.peseninaja.Model.Makanan;
import com.example.peseninaja.R;

import java.util.ArrayList;

public class MakananData {
    private  static String [] makananName = {
            "Nasi Padang",
            "Nasi Goreng",
            "Sate",
            "Soto Betawi",
            "Ayam Betutu"
    };

    private  static String [] makananDesc = {
            "Nasi Asli Padang",
            "Nasi Goreng Enakk",
            "Sate Isinya Banyak",
            "Soto Betawi Sedapp",
            "Ayam Betutu Khas Bu oki"
    };
    private static String [] makananPrice= {
            "15000",
            "10000",
            "20000",
            "10000",
            "15000",
    };

    private static int[] makananImage = {
            R.drawable.padang,
            R.drawable.nasgor,
            R.drawable.sate,
            R.drawable.soto,
            R.drawable.betutu,
    };


    public static ArrayList<Makanan> getListData(){
        ArrayList<Makanan> list = new ArrayList<>();
        for (int position = 0; position<makananName.length; position++){
            Makanan makanan = new Makanan();
            makanan.setName(makananName[position]);
            makanan.setDesc(makananDesc[position]);
            makanan.setPrice(makananPrice[position]);
            makanan.setPhoto(makananImage[position]);
            list.add(makanan);
        }
        return list;
    }
}
