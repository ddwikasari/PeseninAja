package com.example.peseninaja;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.peseninaja.Adapter.MakananAdapter;
import com.example.peseninaja.Adapter.MinumanAdapter;
import com.example.peseninaja.Model.Makanan;
import com.example.peseninaja.Model.Minuman;
import com.example.peseninaja.OrderView;
import com.example.peseninaja.Seeder.MakananData;
import com.example.peseninaja.Seeder.MinumanData;

import java.util.ArrayList;

public class MinumanR extends AppCompatActivity {

    private RecyclerView rvMinuman;
    private ArrayList<Minuman> list = new ArrayList<>();
    Button btnLanjutkan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minuman_r);

        rvMinuman = findViewById(R.id.rvMinuman);
        btnLanjutkan = findViewById(R.id.btnSerahkanMinuman);
        rvMinuman.setHasFixedSize(true);

        list.addAll(MinumanData.getListData());
        rvMinuman.setLayoutManager((new LinearLayoutManager(this)));
        MinumanAdapter listFilmAdapter = new MinumanAdapter(list);
        rvMinuman.setAdapter(listFilmAdapter);

        btnLanjutkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listFilmAdapter.getCheckedMinuman().size() == 0){

                }else{
                    Intent intent = new Intent(MinumanR.this, OrderViewMinuman.class);
                    intent.putParcelableArrayListExtra("minuman_dipilih", listFilmAdapter.getCheckedMinuman());
                    startActivity(intent);
                }
            }
        });
    }
}