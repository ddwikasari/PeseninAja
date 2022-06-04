package com.example.peseninaja;
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
    private static int [] minumanPrice= {
            10000,
            10000,
            5000,
            5000,
            10000,
    };

    private static int[] minumanImage = {
            R.drawable.thaitea,
            R.drawable.kuliner_13,
            R.drawable.esteh,
            R.drawable.es_jeruk,
            R.drawable.milkshake,
    };

    private static int[] minumanCount ={
            0,
            0,
            0,
            0,
            0,
    };

    static ArrayList<Minuman> getListData(){
        ArrayList<Minuman> list = new ArrayList<>();
        for (int position = 0; position<minumanName.length; position++){
            Minuman minuman = new Minuman();
            minuman.setName(minumanName[position]);
            minuman.setDesc(minumanDesc[position]);
            minuman.setPrice(minumanPrice[position]);
            minuman.setPhoto(minumanImage[position]);
            minuman.setCount(minumanCount[position]);
            list.add(minuman);
        }
        return list;
    }
}

