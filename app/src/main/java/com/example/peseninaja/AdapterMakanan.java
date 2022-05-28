package com.example.peseninaja;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class holder extends RecyclerView.ViewHolder{
    ImageView img;
    TextView txtname, txtprice;

    public holder(@NonNull View itemView) {
        super(itemView);

        img = itemView.findViewById(R.id.img_item_photo);
        txtname = itemView.findViewById(R.id.tv_item_name);
        txtprice = itemView.findViewById(R.id.tv_item_price);
    }
}

public class AdapterMakanan extends RecyclerView.Adapter<holder> {
    Context context;
    ArrayList<Makanan> listMakanan;

    public AdapterMakanan(Context context, ArrayList<Makanan> listMakanan) {
        this.context = context;
        this.listMakanan = listMakanan;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_menu, parent, false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {
        Makanan makanan = listMakanan.get(position);
        holder.img.setImageResource(makanan.getImage());
        holder.txtname.setText(makanan.getNama());
        holder.txtprice.setText(""+makanan.getPrice());
    }

    @Override
    public int getItemCount() {
        return listMakanan.size();
    }
}
