package com.example.peseninaja;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Dasbhoard extends AppCompatActivity {

    List<Makanan> lstMakanan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dasbhoard);

        lstMakanan = new ArrayList<>();
        lstMakanan.add(new Makanan("Nasi Goreng", 20000, R.drawable.nasi_kuning));
        lstMakanan.add(new Makanan("Nasi Goreng", 20000, R.drawable.nasi_kuning));
        lstMakanan.add(new Makanan("Nasi Goreng", 20000, R.drawable.nasi_kuning));
        lstMakanan.add(new Makanan("Nasi Goreng", 20000, R.drawable.nasi_kuning));
        lstMakanan.add(new Makanan("Nasi Goreng", 20000, R.drawable.nasi_kuning));

        RecyclerView myrv = findViewById(R.id.recycler_id);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this, lstMakanan);
        myrv.setLayoutManager(new GridLayoutManager(this, 3));
        myrv.setAdapter(myAdapter);

        myAdapter.setOnItemClickCallback(new RecyclerViewAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Makanan makanan) {
                Intent moveIntent = new Intent(Dasbhoard.this, DetailMenu.class);
                moveIntent.putExtra(DetailMenu.ITEM_EXTRA, makanan);
                startActivity(moveIntent);
//                showSelectedMakanan(data);
            }
        });

    }

//    private void showSelectedMakanan(Makanan makanan){
//        Toast.makeText(this, "Bener" + makanan.getTitle(),Toast.LENGTH_SHORT).show();
//    }
}