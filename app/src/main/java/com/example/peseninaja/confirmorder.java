package com.example.peseninaja;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class confirmorder extends AppCompatActivity {

    private EditText namaEditText, notlpEditText, kotaEditText, alamatEditText;
    private Button confirmorderBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmorder);

        confirmorderBtn = (Button) findViewById(R.id.buttonconfirm);
        namaEditText = (EditText) findViewById(R.id.nama_pemesan);
        notlpEditText = (EditText) findViewById(R.id.notlp);
        kotaEditText = (EditText) findViewById(R.id.kota);
        alamatEditText = (EditText) findViewById(R.id.alamat);
    }
}
