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
import com.example.peseninaja.Seeder.SnackData;

import java.util.ArrayList;

public class SnackR extends AppCompatActivity {

    private RecyclerView rvSnack;
    private ArrayList<Makanan> list = new ArrayList<>();
    Button btnLanjutkan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makanan_r);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Snack");


        toolbar.setNavigationIcon(R.drawable.ic_back);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());

        rvSnack = findViewById(R.id.rvMakanan);
        btnLanjutkan = findViewById(R.id.btnSerahkan);
        rvSnack.setHasFixedSize(true);

        list.addAll(SnackData.getListData());
        rvSnack.setLayoutManager((new LinearLayoutManager(this)));
        MakananAdapter listSnackAdapter = new MakananAdapter(list);
        rvSnack.setAdapter(listSnackAdapter);

        btnLanjutkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listSnackAdapter.getCheckedMakanan().size() == 0){

                }else{
                    Intent intent = new Intent(SnackR.this, OrderView.class);
                    intent.putParcelableArrayListExtra("menu_dipilih", listSnackAdapter.getCheckedMakanan());
                    startActivity(intent);
                }
            }
        });

    }
}