package com.example.peseninaja;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Rangkuman Order");


        toolbar.setNavigationIcon(R.drawable.ic_back);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());

        rvOrder = findViewById(R.id.orderMakanan);
        btnOrder = findViewById(R.id.orderButton);
        txtJumlah = findViewById(R.id.totalOrder);
        rvOrder.setHasFixedSize(true);

        Intent ambilData = this.getIntent();
        ArrayList<OrderMakanan> orderMakanan = ambilData.getParcelableArrayListExtra("menu_dipilih");

        HitungTotal hitungTotal = new HitungTotal();
        totalOrder = hitungTotal.hitungTotalOrder(orderMakanan);
        txtJumlah.setText("Rp"+""+totalOrder);

        rvOrder.setLayoutManager((new LinearLayoutManager(this)));
        OrderAdapter listOrderAdapter = new OrderAdapter(orderMakanan);
        rvOrder.setAdapter(listOrderAdapter);

        btnOrder.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(OrderView.this, OrderSuccess.class));
            }
        });
    }

}