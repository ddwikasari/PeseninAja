package com.example.peseninaja;

import java.util.ArrayList;

public class KategoriData {

    private static String [] kategoriName = {
            "Makanan",
            "Minuman",
            "Dessert",
            "Snack"
    };

    private static int[] kategoriImage = {
            R.drawable.makanan,
            R.drawable.minuman,
            R.drawable.dessert,
            R.drawable.snack,
    };

    static ArrayList<Kategori> getListData(){
        ArrayList<Kategori> list = new ArrayList<>();
        for (int position = 0; position <kategoriName.length; position++) {
            Kategori kategori = new Kategori();
            kategori.setName(kategoriName[position]);
            kategori.setPhoto(kategoriImage[position]);
            list.add(kategori);
        }
        return list;
    }
}
