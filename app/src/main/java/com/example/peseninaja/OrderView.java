package com.example.peseninaja;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.peseninaja.Adapter.OrderAdapter;
import com.example.peseninaja.HitungTotal;
import com.example.peseninaja.Model.OrderMakanan;
import com.example.peseninaja.R;

import java.util.ArrayList;

public class OrderView extends AppCompatActivity {
    private RecyclerView rvOrder;
    Button btnOrder;
    private int totalOrder;
    TextView txtJumlah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_view);

        rvOrder = findViewById(R.id.orderMakanan);
        btnOrder = findViewById(R.id.orderButton);
        txtJumlah = findViewById(R.id.totalOrder);
        rvOrder.setHasFixedSize(true);

        Intent ambilData = this.getIntent();
        ArrayList<OrderMakanan> orderMakanan = ambilData.getParcelableArrayListExtra("makanan_dipilih");

        HitungTotal hitungTotal = new HitungTotal();
        totalOrder = hitungTotal.hitungTotalOrder(orderMakanan);
        txtJumlah.setText(""+totalOrder);

        rvOrder.setLayoutManager((new LinearLayoutManager(this)));
        OrderAdapter listFilmAdapter = new OrderAdapter(orderMakanan);
        rvOrder.setAdapter(listFilmAdapter);
    }
}