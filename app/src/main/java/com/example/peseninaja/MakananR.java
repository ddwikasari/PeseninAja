package com.example.peseninaja;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.peseninaja.Adapter.MakananAdapter;
import com.example.peseninaja.Model.Makanan;
import com.example.peseninaja.OrderView;
import com.example.peseninaja.Seeder.MakananData;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class MakananR extends AppCompatActivity {
    private RecyclerView rvMakanan;
    private ArrayList<Makanan> list = new ArrayList<>();
    Button btnLanjutkan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makanan_r);

        rvMakanan = findViewById(R.id.rvMakanan);
        btnLanjutkan = findViewById(R.id.btnSerahkan);
        rvMakanan.setHasFixedSize(true);

        list.addAll(MakananData.getListData());
        rvMakanan.setLayoutManager((new LinearLayoutManager(this)));
        MakananAdapter listFilmAdapter = new MakananAdapter(list);
        rvMakanan.setAdapter(listFilmAdapter);

        btnLanjutkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listFilmAdapter.getCheckedMakanan().size() == 0){

                }else{
                    Intent intent = new Intent(MakananR.this, OrderView.class);
                    intent.putParcelableArrayListExtra("makanan_dipilih", listFilmAdapter.getCheckedMakanan());
                    startActivity(intent);
                }
            }
        });
    }
}