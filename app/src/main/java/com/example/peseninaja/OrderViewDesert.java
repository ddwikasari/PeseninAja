package com.example.peseninaja;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.peseninaja.Adapter.OrderDesertAdapter;
import com.example.peseninaja.Adapter.OrderSnackAdapter;
import com.example.peseninaja.Model.OrderDesert;
import com.example.peseninaja.Model.OrderSnack;

import java.util.ArrayList;

public class OrderViewDesert extends AppCompatActivity {

    private RecyclerView rvOrder;
    Button btnOrder;
    private int totalOrder;
    TextView txtJumlah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_view_desert);

        rvOrder = findViewById(R.id.orderDesert);
        btnOrder = findViewById(R.id.orderButtonDesert);
        txtJumlah = findViewById(R.id.totalOrderDesert);
        rvOrder.setHasFixedSize(true);

        Intent ambilData = this.getIntent();
        ArrayList<OrderDesert> orderDeserts = ambilData.getParcelableArrayListExtra("desert_dipilih");

        HitungTotal hitungTotal = new HitungTotal();
        totalOrder = hitungTotal.hitungTotalOrderDesert(orderDeserts);
        txtJumlah.setText(""+totalOrder);

        rvOrder.setLayoutManager((new LinearLayoutManager(this)));
        OrderDesertAdapter listFilmAdapter = new OrderDesertAdapter(orderDeserts);
        rvOrder.setAdapter(listFilmAdapter);
    }
}