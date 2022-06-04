package com.example.peseninaja.Seeder;

import com.example.peseninaja.Model.Desert;
import com.example.peseninaja.Model.Snack;
import com.example.peseninaja.R;

import java.util.ArrayList;

public class DesertData {

    private  static String [] desertName = {
            "Nasi Kuning",
            "Nasi Goreng",
            "Sate",
            "Soto Betawi"
    };

    private static String [] desertPrice = {
            "15000",
            "10000",
            "20000",
            "10000"
    };

    private static int[] desertImage = {
            R.drawable.padang,
            R.drawable.nasgor,
            R.drawable.sate,
            R.drawable.soto,
    };

    public static ArrayList<Desert> getListData(){
        ArrayList<Desert> list = new ArrayList<>();
        for (int position = 0; position<desertName.length; position++){
            Desert desert = new Desert();
            desert.setName(desertName[position]);
            desert.setPrice(desertPrice[position]);
            desert.setPhoto(desertImage[position]);
            list.add(desert);
        }
        return list;
    }

}
