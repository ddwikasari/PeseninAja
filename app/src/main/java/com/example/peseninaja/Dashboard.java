package com.example.peseninaja;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Dashboard extends AppCompatActivity {
    private RecyclerView rvCategory;
    private ArrayList<Kategori> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        rvCategory = findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        list.addAll(KategoriData.getListData());
        showGrid();
    }

    private void showGrid(){
        rvCategory.setLayoutManager(new GridLayoutManager(this,2));
        GridKategoriAdapter gridKategoriAdapter = new GridKategoriAdapter(list);
        rvCategory.setAdapter(gridKategoriAdapter);
    }
}