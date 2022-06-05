package com.example.peseninaja.Seeder;

import com.example.peseninaja.KopiR;
import com.example.peseninaja.Model.Desert;
import com.example.peseninaja.Model.Kopi;
import com.example.peseninaja.Model.Makanan;
import com.example.peseninaja.R;

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
    private static String [] kopiPrice= {
            "40000",
            "40000",
            "40000",
            "40000",
            "40000",
    };

    private static int[] kopiImage = {
            R.drawable.espresso,
            R.drawable.americano,
            R.drawable.cappucino,
            R.drawable.latte,
            R.drawable.macchiato,
    };


    public static ArrayList<Makanan> getListData(){
        ArrayList<Makanan> list = new ArrayList<>();
        for (int position = 0; position<kopiName.length; position++){
            Makanan kopi = new Makanan();
            kopi.setName(kopiName[position]);
            kopi.setPrice(kopiPrice[position]);
            kopi.setDesc(kopiDesc[position]);
            kopi.setPhoto(kopiImage[position]);
            list.add(kopi);
        }
        return list;
    }
}
