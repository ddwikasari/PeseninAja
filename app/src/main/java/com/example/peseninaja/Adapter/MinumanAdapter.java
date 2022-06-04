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
import com.example.peseninaja.Model.Minuman;
import com.example.peseninaja.Model.OrderMinuman;
import com.example.peseninaja.R;

import java.util.ArrayList;

public class MinumanAdapter extends RecyclerView.Adapter<MinumanAdapter.ListViewHolder> {

    private ArrayList<Minuman> listMinuman;
    private ArrayList<OrderMinuman> pilihMinuman;

    public MinumanAdapter(ArrayList<Minuman> list) {
        this.listMinuman = list;
        pilihMinuman = new ArrayList<>();
    }

    public ArrayList<OrderMinuman> getCheckedMinuman() {
        return pilihMinuman;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ui_minuman, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MinumanAdapter.ListViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Minuman minuman = listMinuman.get(position);
        Glide.with(holder.itemView.getContext())
                .load(minuman.getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgPhoto);
        holder.tvName.setText(minuman.getName());
        holder.tvPrice.setText(minuman.getPrice());
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    OrderMinuman order = new OrderMinuman(listMinuman.get(position).getName(), listMinuman.get(position).getPrice());
                    pilihMinuman.add(order);
                }else{
                    for(int i = 0; i < pilihMinuman.size(); i++) {
                        if(pilihMinuman.get(i).getName() == listMinuman.get(position).getName() && pilihMinuman.get(i).getPrice() == listMinuman.get(position).getPrice()){
                            pilihMinuman.remove(i);
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
        return listMinuman.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName;
        TextView tvPrice;
        CheckBox checkBox;

        ListViewHolder(View itemview) {
            super(itemview);
            imgPhoto = itemview.findViewById(R.id.img_produkMinuman);
            tvName = itemview.findViewById(R.id.tv_namaMinuman);
            tvPrice = itemview.findViewById(R.id.tv_hargaMinuman);
            checkBox = itemview.findViewById(R.id.checkBoxMinuman);
        }
    }
}
