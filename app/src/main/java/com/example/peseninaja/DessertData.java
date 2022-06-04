package com.example.peseninaja;
import java.util.ArrayList;

    public class DessertData {
        private  static String [] dessertName = {
                "Terang Bulan",
                "Donuts",
                "Gelato",
                "Bittersweet",
                "Macaron"
        };

        private  static String [] dessertDesc = {
                "Temennya Martabak",
                "Donat Bulat tengah",
                "es krim",
                "By Najla",
                "warna warni"
        };
        private static int [] dessertPrice= {
                35000,
                30000,
                25000,
                55000,
                100000,
        };

        private static int[] dessertImage = {
                R.drawable.terang_bulan,
                R.drawable.donat,
                R.drawable.gelato,
                R.drawable.bittersweet,
                R.drawable.macaron,
        };

        private static int[] dessertCount ={
                0,
                0,
                0,
                0,
                0,
        };

        static ArrayList<Dessert> getListData(){
            ArrayList<Dessert> list = new ArrayList<>();
            for (int position = 0; position<dessertName.length; position++){
                Dessert dessert = new Dessert();
                dessert.setName(dessertName[position]);
                dessert.setDesc(dessertDesc[position]);
                dessert.setPrice(dessertPrice[position]);
                dessert.setPhoto(dessertImage[position]);
                dessert.setCount(dessertCount[position]);
                list.add(dessert);
            }
            return list;
        }
    }
