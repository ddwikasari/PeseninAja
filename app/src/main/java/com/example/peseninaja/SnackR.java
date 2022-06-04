package com.example.peseninaja;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.peseninaja.Adapter.MinumanAdapter;
import com.example.peseninaja.Adapter.SnackAdapter;
import com.example.peseninaja.Model.Minuman;
import com.example.peseninaja.Model.Snack;
import com.example.peseninaja.Seeder.MinumanData;
import com.example.peseninaja.Seeder.SnackData;

import java.util.ArrayList;

public class SnackR extends AppCompatActivity {

    private RecyclerView rvSnack;
    private ArrayList<Snack> list = new ArrayList<>();
    Button btnLanjutkan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack_r);

        rvSnack = findViewById(R.id.rvSnack);
        btnLanjutkan = findViewById(R.id.btnSerahkanSnack);
        rvSnack.setHasFixedSize(true);

        list.addAll(SnackData.getListData());
        rvSnack.setLayoutManager((new LinearLayoutManager(this)));
        SnackAdapter listFilmAdapter = new SnackAdapter(list);
        rvSnack.setAdapter(listFilmAdapter);

        btnLanjutkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listFilmAdapter.getCheckedSnack().size() == 0){

                }else{
                    Intent intent = new Intent(SnackR.this, OrderViewSnack.class);
                    intent.putParcelableArrayListExtra("snack_dipilih", listFilmAdapter.getCheckedSnack());
                    startActivity(intent);
                }
            }
        });

    }
}