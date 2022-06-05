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
import com.example.peseninaja.Seeder.KopiData;

import java.util.ArrayList;

public class KopiR extends AppCompatActivity {

    private RecyclerView rvKopi;
    private ArrayList<Makanan> list = new ArrayList<>();
    Button btnLanjutkan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makanan_r);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Kopi");


        toolbar.setNavigationIcon(R.drawable.ic_back);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());

        rvKopi = findViewById(R.id.rvMakanan);
        btnLanjutkan = findViewById(R.id.btnSerahkan);
        rvKopi.setHasFixedSize(true);

        list.addAll(KopiData.getListData());
        rvKopi.setLayoutManager((new LinearLayoutManager(this)));
        MakananAdapter listKopiAdapter = new MakananAdapter(list);
        rvKopi.setAdapter(listKopiAdapter);

        btnLanjutkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listKopiAdapter.getCheckedMakanan().size() == 0){

                }else{
                    Intent intent = new Intent(KopiR.this, OrderView.class);
                    intent.putParcelableArrayListExtra("menu_dipilih", listKopiAdapter.getCheckedMakanan());
                    startActivity(intent);
                }
            }
        });
    }
}