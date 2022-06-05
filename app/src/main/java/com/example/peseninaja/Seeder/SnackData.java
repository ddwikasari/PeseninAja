package com.example.peseninaja.Seeder;

import com.example.peseninaja.Model.Makanan;
import com.example.peseninaja.R;

import java.util.ArrayList;

public class SnackData {
    private  static String [] snackName = {
            "Roti Bakar",
            "Tahu Gejrot",
            "Gorengan",
            "Martabak",
            "Dimsum"
    };

    private  static String [] snackDesc = {
            "Roti Bakar Keju dan Coklat",
            "Tahu diGejrot",
            "Tepung digoreng",
            "Martabak Asin",
            "Dimsum Enak"
    };

    private static String [] snackPrice = {
            "15000",
            "10000",
            "1000",
            "25000",
            "15000"
    };

    private static int[] snackImage = {
            R.drawable.roti_bakar,
            R.drawable.tahu_gejrot,
            R.drawable.gorengan,
            R.drawable.martabak,
            R.drawable.dimsum,
    };

    public static ArrayList<Makanan> getListData(){
        ArrayList<Makanan> list = new ArrayList<>();
        for (int position = 0; position<snackName.length; position++){
            Makanan snack = new Makanan();
            snack.setName(snackName[position]);
            snack.setDesc(snackDesc[position]);
            snack.setPrice(snackPrice[position]);
            snack.setPhoto(snackImage[position]);
            list.add(snack);
        }
        return list;
    }
}
