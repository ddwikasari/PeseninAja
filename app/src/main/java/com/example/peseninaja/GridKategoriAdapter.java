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

public class GridKategoriAdapter extends RecyclerView.Adapter<GridKategoriAdapter.ListViewHolder>{
    private ArrayList<Kategori> listKategori;

    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback){
        this.onItemClickCallback = onItemClickCallback;
    }

    public GridKategoriAdapter(ArrayList<Kategori> list){
        this.listKategori = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Kategori kategori = listKategori.get(position);
        Glide.with(holder.itemView.getContext())
                .load(kategori.getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgPhoto);
        holder.tv_name.setText(kategori.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallback.onItemClicked(listKategori.get(holder.getBindingAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {

        return listKategori.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tv_name;

        ListViewHolder(View itemView){
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_category);
            tv_name = itemView.findViewById(R.id.tv_category_name);
        }
    }

    public interface OnItemClickCallback{
        void onItemClicked(Kategori data);
    }
}
