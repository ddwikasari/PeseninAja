package com.example.peseninaja.Seeder;

import com.example.peseninaja.Model.Minuman;
import com.example.peseninaja.Model.Snack;
import com.example.peseninaja.R;

import java.util.ArrayList;

public class SnackData {
    private  static String [] snackName = {
            "Nasi Kuning",
            "Nasi Goreng",
            "Sate",
            "Soto Betawi"
    };

    private static String [] snackPrice = {
            "15000",
            "10000",
            "20000",
            "10000"
    };

    private static int[] snackImage = {
            R.drawable.padang,
            R.drawable.nasgor,
            R.drawable.sate,
            R.drawable.soto,
    };

    public static ArrayList<Snack> getListData(){
        ArrayList<Snack> list = new ArrayList<>();
        for (int position = 0; position<snackName.length; position++){
            Snack snack = new Snack();
            snack.setName(snackName[position]);
            snack.setPrice(snackPrice[position]);
            snack.setPhoto(snackImage[position]);
            list.add(snack);
        }
        return list;
    }
}
