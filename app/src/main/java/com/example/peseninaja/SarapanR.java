package com.example.peseninaja;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.peseninaja.Adapter.MakananAdapter;
import com.example.peseninaja.Model.Makanan;
import com.example.peseninaja.Seeder.SarapanData;

import java.util.ArrayList;

public class SarapanR extends AppCompatActivity {

    private RecyclerView rvSarapan;
    private ArrayList<Makanan> list = new ArrayList<>();
    Button btnLanjutkan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sarapan_r);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Sarapan");


        toolbar.setNavigationIcon(R.drawable.ic_back);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());
        rvSarapan = findViewById(R.id.rvMakanan);
        btnLanjutkan = findViewById(R.id.btnSerahkan);
        rvSarapan.setHasFixedSize(true);

        list.addAll(SarapanData.getListData());
        rvSarapan.setLayoutManager((new LinearLayoutManager(this)));
        MakananAdapter listSarapanAdapter = new MakananAdapter(list);
        rvSarapan.setAdapter(listSarapanAdapter);

        btnLanjutkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listSarapanAdapter.getCheckedMakanan().size() == 0){

                }else{
                    Intent intent = new Intent(SarapanR.this, OrderView.class);
                    intent.putParcelableArrayListExtra("menu_dipilih", listSarapanAdapter.getCheckedMakanan());
                    startActivity(intent);
                }
            }
        });
    }
}