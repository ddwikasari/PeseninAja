package com.example.peseninaja;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.peseninaja.Adapter.KopiAdapter;
import com.example.peseninaja.Adapter.SarapanAdapter;
import com.example.peseninaja.Adapter.SnackAdapter;
import com.example.peseninaja.Model.Kopi;
import com.example.peseninaja.Model.Sarapan;
import com.example.peseninaja.Seeder.KopiData;
import com.example.peseninaja.Seeder.SarapanData;
import com.example.peseninaja.Seeder.SnackData;

import java.util.ArrayList;

public class SarapanR extends AppCompatActivity {

    private RecyclerView rvSarapan;
    private ArrayList<Sarapan> list = new ArrayList<>();
    Button btnLanjutkan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sarapan_r);

        rvSarapan = findViewById(R.id.rvSarapan);
        btnLanjutkan = findViewById(R.id.btnSerahkanSarapan);
        rvSarapan.setHasFixedSize(true);

        list.addAll(SarapanData.getListData());
        rvSarapan.setLayoutManager((new LinearLayoutManager(this)));
        SarapanAdapter listFilmAdapter = new SarapanAdapter(list);
        rvSarapan.setAdapter(listFilmAdapter);

        btnLanjutkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listFilmAdapter.getCheckedSarapan().size() == 0){

                }else{
                    Intent intent = new Intent(SarapanR.this, OrderViewSarapan.class);
                    intent.putParcelableArrayListExtra("sarapan_dipilih", listFilmAdapter.getCheckedSarapan());
                    startActivity(intent);
                }
            }
        });
    }
}