package com.example.peseninaja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailList extends AppCompatActivity {
    public static final String ITEM_EXTRA = "item_extra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_list);

        ImageView imgMakanan = findViewById(R.id.imgMakanan);
        TextView namaMakanan = findViewById(R.id.namaMakanan);
        TextView hargaMakanan = findViewById(R.id.hargaMakanan);

        Makanan makanan = getIntent().getParcelableExtra(ITEM_EXTRA);
        if (makanan != null){
            Glide.with(this)
                    .load(makanan.getImage())
                    .into(imgMakanan);
            namaMakanan.setText(makanan.getNama());
            hargaMakanan.setText(makanan.getPrice());
        }
        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle("Detail");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
    @Override
    public boolean onSupportNavigateUp(){
        return true;
    }
}