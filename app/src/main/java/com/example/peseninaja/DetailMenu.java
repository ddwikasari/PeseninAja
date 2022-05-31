package com.example.peseninaja;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailMenu extends AppCompatActivity {
    public static final String ITEM_EXTRA = "item_extra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_menu);

        ImageView imgDetail = findViewById(R.id.detail_gambar_id);
        TextView namaDetail = findViewById(R.id.detail_nama);
        TextView hargaDetail = findViewById(R.id.detail_harga);

        Makanan makanan = getIntent().getParcelableExtra(ITEM_EXTRA);
        if (makanan != null){
            Glide.with(this)
                    .load(makanan.getPhoto())
                    .into(imgDetail);
            namaDetail.setText(makanan.getTitle());
            hargaDetail.setText(makanan.getPrice());
        }

        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle("Detail Menu");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}