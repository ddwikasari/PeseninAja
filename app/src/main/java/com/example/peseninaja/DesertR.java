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
import com.example.peseninaja.Seeder.DesertData;

import java.util.ArrayList;

public class DesertR extends AppCompatActivity {

    private RecyclerView rvDesert;
    private ArrayList<Makanan> list = new ArrayList<>();
    Button btnLanjutkan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makanan_r);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Dessert");


        toolbar.setNavigationIcon(R.drawable.ic_back);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());

        rvDesert = findViewById(R.id.rvMakanan);
        btnLanjutkan = findViewById(R.id.btnSerahkan);
        rvDesert.setHasFixedSize(true);

        list.addAll(DesertData.getListData());
        rvDesert.setLayoutManager((new LinearLayoutManager(this)));
        MakananAdapter listDesertAdapter = new MakananAdapter(list);
        rvDesert.setAdapter(listDesertAdapter);

        btnLanjutkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listDesertAdapter.getCheckedMakanan().size() == 0){

                }else{
                    Intent intent = new Intent(DesertR.this, OrderView.class);
                    intent.putParcelableArrayListExtra("menu_dipilih", listDesertAdapter.getCheckedMakanan());
                    startActivity(intent);
                }
            }
        });
    }
}