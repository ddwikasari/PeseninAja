package com.example.peseninaja;
import java.util.ArrayList;

public class MakananData {
    private  static String [] makananName = {
            "Nasi Kuning",
            "Nasi Goreng",
            "Sate",
            "Soto Betawi",
            "Ayam Betutu"
    };

    private  static String [] makananDesc = {
            "Nasi Kuning Enak Banget",
            "Nasi Goreng Enakk",
            "Sate Isinya Banyal",
            "Soto Betawi Sedapp",
            "Ayam Betutu Khas Bu oki"
    };
    private static int [] makananPrice= {
            15000,
            10000,
            20000,
            10000,
            15000,
    };

    private static int[] makananImage = {
            R.drawable.padang,
            R.drawable.nasgor,
            R.drawable.sate,
            R.drawable.soto,
            R.drawable.betutu,
    };

    private static int[] makananCount ={
            0,
            0,
            0,
            0,
            0,
    };

    static ArrayList<Makanan> getListData(){
        ArrayList<Makanan> list = new ArrayList<>();
        for (int position = 0; position<makananName.length; position++){
            Makanan makanan = new Makanan();
            makanan.setName(makananName[position]);
            makanan.setDesc(makananDesc[position]);
            makanan.setPrice(makananPrice[position]);
            makanan.setPhoto(makananImage[position]);
            makanan.setCount(makananCount[position]);
            list.add(makanan);
        }
        return list;
    }
}
