package com.example.peseninaja;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.peseninaja.Adapter.DesertAdapter;
import com.example.peseninaja.Adapter.SnackAdapter;
import com.example.peseninaja.Model.Desert;
import com.example.peseninaja.Model.Snack;
import com.example.peseninaja.Seeder.DesertData;
import com.example.peseninaja.Seeder.SnackData;

import java.util.ArrayList;

public class DesertR extends AppCompatActivity {

    private RecyclerView rvDesert;
    private ArrayList<Desert> list = new ArrayList<>();
    Button btnLanjutkan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desert_r);

        rvDesert = findViewById(R.id.rvDesert);
        btnLanjutkan = findViewById(R.id.btnSerahkanDesert);
        rvDesert.setHasFixedSize(true);

        list.addAll(DesertData.getListData());
        rvDesert.setLayoutManager((new LinearLayoutManager(this)));
        DesertAdapter listFilmAdapter = new DesertAdapter(list);
        rvDesert.setAdapter(listFilmAdapter);

        btnLanjutkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listFilmAdapter.getCheckedDesert().size() == 0){

                }else{
                    Intent intent = new Intent(DesertR.this, OrderViewDesert.class);
                    intent.putParcelableArrayListExtra("desert_dipilih", listFilmAdapter.getCheckedDesert());
                    startActivity(intent);
                }
            }
        });
    }
}