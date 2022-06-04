package com.example.peseninaja;
import java.util.ArrayList;

public class SarapanData {
    private  static String [] sarapanName = {
            "Bubur",
            "Nasi Kuning",
            "Pancake",
            "Toast",
            "Scrambled Egg"
    };

    private  static String [] sarapanDesc = {
            "ini bubur naik haji",
            "nasi warna kuning",
            "ini pancake",
            "ini toast",
            "ini scrambled egg"
    };
    private static int [] sarapanPrice= {
            5000,
            5000,
            25000,
            15000,
            15000,
    };

    private static int[] sarapanImage = {
            R.drawable.bubur,
            R.drawable.nasikuning,
            R.drawable.pancake,
            R.drawable.toast,
            R.drawable.scrambledegg,
    };

    private static int[] sarapanCount ={
            0,
            0,
            0,
            0,
            0,
    };

    static ArrayList<Sarapan> getListData(){
        ArrayList<Sarapan> list = new ArrayList<>();
        for (int position = 0; position<sarapanName.length; position++){
            Sarapan sarapan = new Sarapan();
            sarapan.setName(sarapanName[position]);
            sarapan.setDesc(sarapanDesc[position]);
            sarapan.setPrice(sarapanPrice[position]);
            sarapan.setPhoto(sarapanImage[position]);
            sarapan.setCount(sarapanCount[position]);
            list.add(sarapan);
        }
        return list;
    }
}
