package com.example.peseninaja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class OrderSuccess extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_success);
        Thread thread = new Thread(){
            public void run(){
                try{
                    sleep(6000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                } finally {
                    startActivity(new Intent(OrderSuccess.this, Dashboard.class));
                    finish();
                }
            }
        };
        thread.start();
    }
}