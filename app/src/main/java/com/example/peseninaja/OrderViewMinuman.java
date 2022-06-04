package com.example.peseninaja;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.peseninaja.Adapter.OrderAdapter;
import com.example.peseninaja.Adapter.OrderMinumanAdapter;
import com.example.peseninaja.HitungTotal;
import com.example.peseninaja.Model.OrderMinuman;
import com.example.peseninaja.R;

import java.util.ArrayList;

public class OrderViewMinuman extends AppCompatActivity {

    private RecyclerView rvOrder;
    Button btnOrder;
    private int totalOrder;
    TextView txtJumlah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_view_minuman);

        rvOrder = findViewById(R.id.orderMinuman);
        btnOrder = findViewById(R.id.orderButtonMinuman);
        txtJumlah = findViewById(R.id.totalOrderMinuman);
        rvOrder.setHasFixedSize(true);

        Intent ambilData = this.getIntent();
        ArrayList<OrderMinuman> orderMinuman = ambilData.getParcelableArrayListExtra("minuman_dipilih");

        HitungTotal hitungTotal = new HitungTotal();
        totalOrder = hitungTotal.hitungTotalOrderMinuman(orderMinuman);
        txtJumlah.setText(""+totalOrder);

        rvOrder.setLayoutManager((new LinearLayoutManager(this)));
        OrderMinumanAdapter listFilmAdapter = new OrderMinumanAdapter(orderMinuman);
        rvOrder.setAdapter(listFilmAdapter);
    }
}