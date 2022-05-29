package com.example.peseninaja;

import java.util.ArrayList;

public class MakananData {
    private static String [] makananNama = {
            "Bakso",
            "Nasi Goreng",
            "Mie Goreng"
    };

    private static int [] makananHarga = {
            30000,
            20000,
            10000
    };

    private  static int [] makananGambar = {
            R.drawable.sate,
            R.drawable.rendang,
            R.drawable.rawon
    };

    static ArrayList<Makanan> getListData(){
        ArrayList<Makanan> list = new ArrayList<>();
        for (int position = 0; position <makananNama.length; position++){
            Makanan makanan = new Makanan();
            makanan.setNama(makananNama[position]);
            makanan.setPrice(makananHarga[position]);
            makanan.setImage(makananGambar[position]);
        }
        return list;
    }
}
