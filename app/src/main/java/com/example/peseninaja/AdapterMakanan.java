package com.example.peseninaja;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class AdapterMakanan extends RecyclerView.Adapter<AdapterMakanan.listViewHolder>{
    private ArrayList<Makanan> listMakanan;

    public AdapterMakanan(ArrayList<Makanan> list){
        this.listMakanan = list;
    }

    @NonNull
    @Override
    public listViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu, parent, false);
        return new listViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull listViewHolder holder, int position) {
        Makanan makanan = listMakanan.get(position);
        Glide.with(holder.itemView.getContext())
                .load(makanan.getImage())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgPhoto);
        holder.tv_name.setText(makanan.getNama());
        holder.tv_price.setText(makanan.getPrice());

    }

    @Override
    public int getItemCount() {
        return listMakanan.size();
    }

    public class listViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tv_name;
        TextView tv_price;

        public listViewHolder(View itemview) {
            super(itemview);
            imgPhoto = itemview.findViewById(R.id.img_item_photo);
            tv_name = itemview.findViewById(R.id.tv_item_name);
            tv_price = itemview.findViewById(R.id.tv_item_price);
        }
    }
}
