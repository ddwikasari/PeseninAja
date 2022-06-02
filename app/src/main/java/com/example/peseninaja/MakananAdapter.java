package com.example.peseninaja;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class MakananAdapter extends RecyclerView.Adapter<MakananAdapter.ListViewHolder>{
    private ArrayList<Makanan> listMakanan;

    public MakananAdapter(ArrayList<Makanan> list){
        this.listMakanan = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ui_makanan,parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Makanan makanan = listMakanan.get(position);
        Glide.with(holder.itemView.getContext())
                .load(makanan.getPhoto())
                .apply(new RequestOptions().override(55,55))
                .into(holder.imgMenu);
        holder.tvName.setText(makanan.getName());
        holder.tvPrice.setText(makanan.getPrice());
    }

    @Override
    public int getItemCount() {

        return listMakanan.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgMenu;
        TextView tvName, tvPrice;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgMenu = itemView.findViewById(R.id.img_produk);
            tvName = itemView.findViewById(R.id.tv_nama);
            tvPrice = itemView.findViewById(R.id.tv_harga);
        }
    }
}
