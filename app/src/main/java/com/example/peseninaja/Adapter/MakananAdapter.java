package com.example.peseninaja.Adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.peseninaja.Model.Makanan;
import com.example.peseninaja.Model.OrderMakanan;
import com.example.peseninaja.R;

import java.util.ArrayList;

public class MakananAdapter extends RecyclerView.Adapter<MakananAdapter.ListViewHolder> {
    private ArrayList<Makanan> listMakanan;
    private ArrayList<OrderMakanan> pilihMakanan;

    public MakananAdapter(ArrayList<Makanan> list) {
        this.listMakanan = list;
        pilihMakanan = new ArrayList<>();
    }

    public ArrayList<OrderMakanan> getCheckedMakanan() {
        return pilihMakanan;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ui_makanan, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Makanan makanan = listMakanan.get(position);
        Glide.with(holder.itemView.getContext())
                .load(makanan.getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgPhoto);
        holder.tvName.setText(makanan.getName());
        holder.tvPrice.setText(makanan.getPrice());
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    OrderMakanan order = new OrderMakanan(listMakanan.get(position).getName(), listMakanan.get(position).getPrice());
                    pilihMakanan.add(order);
                }else{
                    for(int i = 0; i < pilihMakanan.size(); i++) {
                        if(pilihMakanan.get(i).getName() == listMakanan.get(position).getName() && pilihMakanan.get(i).getPrice() == listMakanan.get(position).getPrice()){
                            pilihMakanan.remove(i);
                        }
                    }
//                    OrderMakanan rmvorder = new OrderMakanan(listMakanan.get(position).getName(), listMakanan.get(position).getPrice());
//                    pilihMakanan.remove(rmvorder);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listMakanan.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName;
        TextView tvPrice;
        CheckBox checkBox;

        ListViewHolder(View itemview) {
            super(itemview);
            imgPhoto = itemview.findViewById(R.id.img_produk);
            tvName = itemview.findViewById(R.id.tv_nama);
            tvPrice = itemview.findViewById(R.id.tv_harga);
            checkBox = (CheckBox) itemView.findViewById(R.id.checkBox);
        }
    }

}