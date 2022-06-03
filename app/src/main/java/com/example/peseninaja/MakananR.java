package com.example.peseninaja;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MakananR extends AppCompatActivity {
    private RecyclerView rvMakanan;
    private ArrayList<Makanan> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makanan_r);

        rvMakanan = findViewById(R.id.rv_makanan);
        rvMakanan.setHasFixedSize(true);

        list.addAll(DataMakanan.getListData());
        showRecyclerList();
    }

    private void showRecyclerList() {
        rvMakanan.setLayoutManager((new LinearLayoutManager(this)));
        ListMakananAdapter listFilmAdapter = new ListMakananAdapter(list);
        rvMakanan.setAdapter(listFilmAdapter);
    }
}