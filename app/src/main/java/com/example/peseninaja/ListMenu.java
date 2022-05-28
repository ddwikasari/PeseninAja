package com.example.peseninaja;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ListMenu extends AppCompatActivity {
    RecyclerView rMakanan;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Makanan> listMakanan;

    void dataDummy(){
        listMakanan = new ArrayList<>();
        listMakanan.add(new Makanan( "Burger", 15000, R.drawable.nasi_kuning));
        listMakanan.add(new Makanan( "Rawon", 20000, R.drawable.rawon));
        listMakanan.add(new Makanan( "rendang", 10000, R.drawable.rendang));
    }
    void data(){
        rMakanan = findViewById(R.id.rv_menu);
        adapter = new AdapterMakanan(this, listMakanan);
        layoutManager = new LinearLayoutManager(this);
        rMakanan.setLayoutManager(layoutManager);
        rMakanan.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_menu);

        dataDummy();data();

    }
}