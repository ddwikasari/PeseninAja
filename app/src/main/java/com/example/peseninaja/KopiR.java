package com.example.peseninaja;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.peseninaja.Adapter.DesertAdapter;
import com.example.peseninaja.Adapter.KopiAdapter;
import com.example.peseninaja.Model.Desert;
import com.example.peseninaja.Model.Kopi;
import com.example.peseninaja.Seeder.DesertData;
import com.example.peseninaja.Seeder.KopiData;

import java.util.ArrayList;

public class KopiR extends AppCompatActivity {

    private RecyclerView rvKopi;
    private ArrayList<Kopi> list = new ArrayList<>();
    Button btnLanjutkan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kopi_r);

        rvKopi = findViewById(R.id.rvKopi);
        btnLanjutkan = findViewById(R.id.btnSerahkanKopi);
        rvKopi.setHasFixedSize(true);

        list.addAll(KopiData.getListData());
        rvKopi.setLayoutManager((new LinearLayoutManager(this)));
        KopiAdapter listFilmAdapter = new KopiAdapter(list);
        rvKopi.setAdapter(listFilmAdapter);

        btnLanjutkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listFilmAdapter.getCheckedKopi().size() == 0){

                }else{
                    Intent intent = new Intent(KopiR.this, OrderViewKopi.class);
                    intent.putParcelableArrayListExtra("kopi_dipilih", listFilmAdapter.getCheckedKopi());
                    startActivity(intent);
                }
            }
        });
    }
}