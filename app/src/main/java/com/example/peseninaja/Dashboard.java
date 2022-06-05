package com.example.peseninaja;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.peseninaja.Seeder.InfoFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class  Dashboard extends AppCompatActivity implements View.OnClickListener {

//    int[] images = {R.drawable.makan};
    private CardView makanan, minuman, snack, desert, kopi, sarapan;

    BottomNavigationView bottomNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dasbhoard);

        bottomNavigation = findViewById(R.id.item_bottom_navigasi);
        bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item){
                Fragment selectedFragment = null;
                switch (item.getItemId()){
                    case R.id.info:
                        selectedFragment = new InfoFragment();
                    case R.id.promo:
                        selectedFragment = new PromoFragment();
                    case R.id.beranda:
                        startActivity(new Intent(Dashboard.this, Dashboard.class));
                        break;

                    case R.id.pesanan:
                        selectedFragment = new PesananFragment();
                        break;
                    case R.id.diskusi:
                        selectedFragment = new ChatFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                return true;
            }
        });

        makanan = findViewById(R.id.card_makanan);
        minuman = findViewById(R.id.card_minuman);
        snack = findViewById(R.id.card_snack);
        desert = findViewById(R.id.card_desert);
        kopi = findViewById(R.id.card_kopi);
        sarapan = findViewById(R.id.card_sarapan);


        makanan.setOnClickListener(this);
        minuman.setOnClickListener(this);
        snack.setOnClickListener(this);
        desert.setOnClickListener(this);
        kopi.setOnClickListener(this);
        sarapan.setOnClickListener(this);
//        makanan.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent BukaMakanan = new Intent(getApplicationContext(), MakananR.class);
//            }
//        });
    }

    @Override
    public void onClick(View view) {
        Intent i;
        switch (view.getId()){
            case R.id.card_makanan:i=new Intent(this, MakananR.class);startActivity(i);
            break;

            case R.id.card_minuman:i=new Intent(this, MinumanR.class);startActivity(i);
            break;

            case R.id.card_snack:i=new Intent(this, SnackR.class);startActivity(i);
            break;

            case R.id.card_desert:i=new Intent(this, DesertR.class);startActivity(i);
            break;

            case R.id.card_kopi:i=new Intent(this, KopiR.class);startActivity(i);
            break;

            case R.id.card_sarapan:i=new Intent(this, SarapanR.class);startActivity(i);
            break;

            default:break;
        }

    }
}