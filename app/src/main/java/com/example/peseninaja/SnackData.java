package com.example.peseninaja;
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
    private static int [] snackPrice= {
            15000,
            10000,
            1000,
            25000,
            15000,
    };

    private static int[] snackImage = {
            R.drawable.roti_bakar,
            R.drawable.tahu_gejrot,
            R.drawable.gorengan,
            R.drawable.martabak,
            R.drawable.dimsum,
    };

    private static int[] snackCount ={
            0,
            0,
            0,
            0,
            0,
    };

    static ArrayList<Snack> getListData(){
        ArrayList<Snack> list = new ArrayList<>();
        for (int position = 0; position<snackName.length; position++){
            Snack snack = new Snack();
            snack.setName(snackName[position]);
            snack.setDesc(snackDesc[position]);
            snack.setPrice(snackPrice[position]);
            snack.setPhoto(snackImage[position]);
            snack.setCount(snackCount[position]);
            list.add(snack);
        }
        return list;
    }
}
