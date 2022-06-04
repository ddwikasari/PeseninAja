package com.example.peseninaja;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.peseninaja.Adapter.OrderDesertAdapter;
import com.example.peseninaja.Adapter.OrderKopiAdapter;
import com.example.peseninaja.Model.OrderDesert;
import com.example.peseninaja.Model.OrderKopi;

import java.util.ArrayList;

public class OrderViewKopi extends AppCompatActivity {

    private RecyclerView rvOrder;
    Button btnOrder;
    private int totalOrder;
    TextView txtJumlah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_view_kopi);

        rvOrder = findViewById(R.id.orderKopi);
        btnOrder = findViewById(R.id.orderButtonKopi);
        txtJumlah = findViewById(R.id.totalOrderKopi);
        rvOrder.setHasFixedSize(true);

        Intent ambilData = this.getIntent();
        ArrayList<OrderKopi> orderKopi = ambilData.getParcelableArrayListExtra("kopi_dipilih");

        HitungTotal hitungTotal = new HitungTotal();
        totalOrder = hitungTotal.hitungTotalOrderKopi(orderKopi);
        txtJumlah.setText(""+totalOrder);

        rvOrder.setLayoutManager((new LinearLayoutManager(this)));
        OrderKopiAdapter listFilmAdapter = new OrderKopiAdapter(orderKopi);
        rvOrder.setAdapter(listFilmAdapter);
    }
}