package com.example.peseninaja;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class Dashboard extends AppCompatActivity {
    private RecyclerView rvCategory;
    private ArrayList<Kategori> list = new ArrayList<>();

//    String bukaMakanan, bukaMinuman, bukaDessert, bukaSnack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

//        bukaMakanan = (String) findViewById(R.id.);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        rvCategory = findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        list.addAll(KategoriData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList(){
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        GridKategoriAdapter gridKategoriAdapter = new GridKategoriAdapter(list);
        rvCategory.setAdapter(gridKategoriAdapter);

        gridKategoriAdapter.setOnItemClickCallback (new GridKategoriAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Kategori data) {
//                Intent moveIntent = new Intent(Dashboard.this, ListMenu.class);
//                moveIntent.putExtra(ListMenu.ITEM)
                showSelectedKategori(data);
            }
        });
    }

    private void showSelectedKategori(Kategori kategori){
        Toast.makeText(this, "kamumemilih" + kategori.getName(),Toast.LENGTH_SHORT).show();
    }
}