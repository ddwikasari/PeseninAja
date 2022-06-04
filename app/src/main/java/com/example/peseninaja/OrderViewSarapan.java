package com.example.peseninaja;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.peseninaja.Adapter.OrderKopiAdapter;
import com.example.peseninaja.Adapter.OrderSarapanAdapter;
import com.example.peseninaja.Model.OrderKopi;
import com.example.peseninaja.Model.OrderSarapan;

import java.util.ArrayList;

public class OrderViewSarapan extends AppCompatActivity {

    private RecyclerView rvOrder;
    Button btnOrder;
    private int totalOrder;
    TextView txtJumlah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_view_sarapan);

        rvOrder = findViewById(R.id.orderSarapan);
        btnOrder = findViewById(R.id.orderButtonSarapan);
        txtJumlah = findViewById(R.id.totalOrderSarapan);
        rvOrder.setHasFixedSize(true);

        Intent ambilData = this.getIntent();
        ArrayList<OrderSarapan> orderSarapan = ambilData.getParcelableArrayListExtra("sarapan_dipilih");

        HitungTotal hitungTotal = new HitungTotal();
        totalOrder = hitungTotal.hitungTotalOrderSarapan(orderSarapan);
        txtJumlah.setText(""+totalOrder);

        rvOrder.setLayoutManager((new LinearLayoutManager(this)));
        OrderSarapanAdapter listFilmAdapter = new OrderSarapanAdapter(orderSarapan);
        rvOrder.setAdapter(listFilmAdapter);
    }
}