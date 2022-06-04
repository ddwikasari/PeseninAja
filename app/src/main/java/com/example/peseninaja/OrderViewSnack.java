package com.example.peseninaja;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.peseninaja.Adapter.OrderMinumanAdapter;
import com.example.peseninaja.Adapter.OrderSnackAdapter;
import com.example.peseninaja.Model.OrderMinuman;
import com.example.peseninaja.Model.OrderSnack;

import java.util.ArrayList;

public class OrderViewSnack extends AppCompatActivity {

    private RecyclerView rvOrder;
    Button btnOrder;
    private int totalOrder;
    TextView txtJumlah;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_view_snack);

        rvOrder = findViewById(R.id.orderSnack);
        btnOrder = findViewById(R.id.orderButtonSnack);
        txtJumlah = findViewById(R.id.totalOrderSnack);
        rvOrder.setHasFixedSize(true);

        Intent ambilData = this.getIntent();
        ArrayList<OrderSnack> orderSnack = ambilData.getParcelableArrayListExtra("snack_dipilih");

        HitungTotal hitungTotal = new HitungTotal();
        totalOrder = hitungTotal.hitungTotalOrderSnack(orderSnack);
        txtJumlah.setText(""+totalOrder);

        rvOrder.setLayoutManager((new LinearLayoutManager(this)));
        OrderSnackAdapter listFilmAdapter = new OrderSnackAdapter(orderSnack);
        rvOrder.setAdapter(listFilmAdapter);
    }

}