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
import com.example.peseninaja.Model.Kopi;
import com.example.peseninaja.Model.OrderKopi;
import com.example.peseninaja.Model.OrderSarapan;
import com.example.peseninaja.Model.Sarapan;
import com.example.peseninaja.R;

import java.util.ArrayList;

public class SarapanAdapter extends RecyclerView.Adapter<SarapanAdapter.ListViewHolder> {
    private ArrayList<Sarapan> listSarapan;
    private ArrayList<OrderSarapan> pilihSarapan;

    public SarapanAdapter(ArrayList<Sarapan> listSarapan) {
        this.listSarapan = listSarapan;
        pilihSarapan = new ArrayList<>();
    }

    public ArrayList<OrderSarapan> getCheckedSarapan() {
        return pilihSarapan;
    }

    @NonNull
    @Override
    public SarapanAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ui_sarapan, parent, false);
        return new SarapanAdapter.ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SarapanAdapter.ListViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Sarapan sarapan = listSarapan.get(position);
        Glide.with(holder.itemView.getContext())
                .load(sarapan.getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgPhoto);
        holder.tvName.setText(sarapan.getName());
        holder.tvPrice.setText(sarapan.getPrice());
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    OrderSarapan order = new OrderSarapan(listSarapan.get(position).getName(), listSarapan.get(position).getPrice());
                    pilihSarapan.add(order);
                }else{
                    for(int i = 0; i < pilihSarapan.size(); i++) {
                        if(pilihSarapan.get(i).getName() == pilihSarapan.get(position).getName() && pilihSarapan.get(i).getPrice() == listSarapan.get(position).getPrice()){
                            pilihSarapan.remove(i);
                        }
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listSarapan.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName;
        TextView tvPrice;
        CheckBox checkBox;

        ListViewHolder(View itemview) {
            super(itemview);
            imgPhoto = itemview.findViewById(R.id.img_produkSarapan);
            tvName = itemview.findViewById(R.id.tv_namaSarapan);
            tvPrice = itemview.findViewById(R.id.tv_hargaSarapan);
            checkBox = itemview.findViewById(R.id.checkBoxSarapan);
        }
    }
}
