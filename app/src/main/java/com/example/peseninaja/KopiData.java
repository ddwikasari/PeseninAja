package com.example.peseninaja;
import java.util.ArrayList;

public class KopiData {
    private  static String [] kopiName = {
            "Espresso",
            "Americano",
            "Cappucino",
            "Latte",
            "Macchiato"
    };

    private  static String [] kopiDesc = {
            "ini Kopi Espresso",
            "ini Kopi Americano",
            "ini Kopi Cappucino",
            "ini Latte",
            "ini Macchiato"
    };
    private static int [] kopiPrice= {
            40000,
            40000,
            40000,
            40000,
            40000,
    };

    private static int[] kopiImage = {
            R.drawable.espresso,
            R.drawable.americano,
            R.drawable.cappucino,
            R.drawable.latte,
            R.drawable.macchiato,
    };

    private static int[] kopiCount ={
            0,
            0,
            0,
            0,
            0,
    };

    static ArrayList<Kopi> getListData(){
        ArrayList<Kopi> list = new ArrayList<>();
        for (int position = 0; position<kopiName.length; position++){
            Kopi kopi = new Kopi();
            kopi.setName(kopiName[position]);
            kopi.setDesc(kopiDesc[position]);
            kopi.setPrice(kopiPrice[position]);
            kopi.setCount(kopiCount[position]);
            kopi.setPhoto(kopiImage[position]);
            list.add(kopi);
        }
        return list;
    }
}

