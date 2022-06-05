package com.example.peseninaja.Seeder;

import com.example.peseninaja.Model.Makanan;
import com.example.peseninaja.R;

import java.util.ArrayList;

public class DesertData {

    private  static String [] desertName = {
            "Terang Bulan",
            "Donuts",
            "Gelato",
            "Bittersweet",
            "Macaron"
    };

    private  static String [] desertDesc = {
            "Temennya Martabak",
            "Donat Bulat tengah",
            "Es krim dingin",
            "By Najla",
            "warna warni"
    };

    private static String [] desertPrice = {
            "35000",
            "30000",
            "25000",
            "55000",
            "100000",
    };

    private static int[] desertImage = {
            R.drawable.terang_bulan,
            R.drawable.donat,
            R.drawable.gelato,
            R.drawable.bittersweet,
            R.drawable.macaron,
    };


    public static ArrayList<Makanan> getListData(){
        ArrayList<Makanan> list = new ArrayList<>();
        for (int position = 0; position<desertName.length; position++){
            Makanan desert = new Makanan();
            desert.setName(desertName[position]);
            desert.setDesc(desertDesc[position]);
            desert.setPrice(desertPrice[position]);
            desert.setPhoto(desertImage[position]);
            list.add(desert);
        }
        return list;
    }

}
