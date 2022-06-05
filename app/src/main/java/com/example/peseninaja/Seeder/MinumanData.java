package com.example.peseninaja.Seeder;

import com.example.peseninaja.Model.Makanan;
import com.example.peseninaja.R;

import java.util.ArrayList;

public class MinumanData {
    private  static String [] minumanName = {
            "Thai Tea",
            "Jus",
            "Es Teh",
            "Es Jeruk",
            "Milk Shake"
    };

    private  static String [] minumanDesc = {
            "Teh Thailand",
            "Buah di Blender",
            "Seduhan Teh Kantong diberi ES",
            "Perasan air jeruk diberi ES",
            "Susu kocok"
    };

    private static String [] minumanPrice = {
            "10000",
            "10000",
            "5000",
            "5000",
            "10000"
    };

    private static int[] minumanImage = {
            R.drawable.thaitea,
            R.drawable.kuliner_13,
            R.drawable.esteh,
            R.drawable.es_jeruk,
            R.drawable.milkshake,
    };

    public static ArrayList<Makanan> getListData(){
        ArrayList<Makanan> list = new ArrayList<>();
        for (int position = 0; position<minumanName.length; position++){
            Makanan minuman  = new Makanan();
            minuman.setName(minumanName[position]);
            minuman.setDesc(minumanDesc[position]);
            minuman.setPrice(minumanPrice[position]);
            minuman.setPhoto(minumanImage[position]);
            list.add(minuman);
        }
        return list;
    }
}
