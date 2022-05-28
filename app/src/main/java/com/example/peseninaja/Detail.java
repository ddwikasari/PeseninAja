package com.example.peseninaja;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_menu);

        ImageView imageView = findViewById(R.id.imageView);
        TextView textView = findViewById(R.id.tv_item_name);

        Intent intent = getIntent();

        int detailGambar = intent.getIntExtra("GAMBAR", 0);
        String namaMakanan = intent.getStringExtra("teks");

        imageView.setImageResource(detailGambar);
        textView.setText(namaMakanan);

    }
}