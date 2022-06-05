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
import com.example.peseninaja.Seeder.MinumanData;

import java.util.ArrayList;

public class MinumanR extends AppCompatActivity {

    private RecyclerView rvMinuman;
    private ArrayList<Makanan> list = new ArrayList<>();
    Button btnLanjutkan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makanan_r);

        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Minuman");


        toolbar.setNavigationIcon(R.drawable.ic_back);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());

        rvMinuman = findViewById(R.id.rvMakanan);
        btnLanjutkan = findViewById(R.id.btnSerahkan);
        rvMinuman.setHasFixedSize(true);

        list.addAll(MinumanData.getListData());
        rvMinuman.setLayoutManager((new LinearLayoutManager(this)));
        MakananAdapter listMinumanAdapter = new MakananAdapter(list);
        rvMinuman.setAdapter(listMinumanAdapter);

        btnLanjutkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listMinumanAdapter.getCheckedMakanan().size() == 0){

                }else{
                    Intent intent = new Intent(MinumanR.this, OrderView.class);
                    intent.putParcelableArrayListExtra("menu_dipilih", listMinumanAdapter.getCheckedMakanan());
                    startActivity(intent);
                }
            }
        });
    }
}