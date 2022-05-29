package com.example.peseninaja;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.android.material.datepicker.MaterialDatePicker;

import java.util.ArrayList;

public class list_menu extends AppCompatActivity {
    private RecyclerView rvMakanan;
    private ArrayList<Makanan> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_menu);

        rvMakanan = findViewById(R.id.rv_menu);
        rvMakanan.setHasFixedSize(true);

        list.addAll(MakananData.getListData());
        showRecyclerList();

    }

    private void showRecyclerList(){
        rvMakanan.setLayoutManager(new LinearLayoutManager(this));
        AdapterMakanan adapterMakanan = new AdapterMakanan(list);
        rvMakanan.setAdapter(adapterMakanan);
    }
}
