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
import com.example.peseninaja.Model.Desert;
import com.example.peseninaja.Model.Kopi;
import com.example.peseninaja.Model.OrderDesert;
import com.example.peseninaja.Model.OrderKopi;
import com.example.peseninaja.R;

import java.util.ArrayList;

public class KopiAdapter extends RecyclerView.Adapter<KopiAdapter.ListViewHolder> {
    private ArrayList<Kopi> listKopi;
    private ArrayList<OrderKopi> pilihKopi;

    public KopiAdapter(ArrayList<Kopi> listKopi) {
        this.listKopi = listKopi;
        pilihKopi = new ArrayList<>();
    }

    public ArrayList<OrderKopi> getCheckedKopi() {
        return pilihKopi;
    }

    @NonNull
    @Override
    public KopiAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ui_kopi, parent, false);
        return new KopiAdapter.ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Kopi kopi = listKopi.get(position);
        Glide.with(holder.itemView.getContext())
                .load(kopi.getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgPhoto);
        holder.tvName.setText(kopi.getName());
        holder.tvPrice.setText(kopi.getPrice());
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    OrderKopi order = new OrderKopi(listKopi.get(position).getName(), listKopi.get(position).getPrice());
                    pilihKopi.add(order);
                }else{
                    for(int i = 0; i < pilihKopi.size(); i++) {
                        if(pilihKopi.get(i).getName() == listKopi.get(position).getName() && pilihKopi.get(i).getPrice() == listKopi.get(position).getPrice()){
                            pilihKopi.remove(i);
                        }
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listKopi.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName;
        TextView tvPrice;
        CheckBox checkBox;

        ListViewHolder(View itemview) {
            super(itemview);
            imgPhoto = itemview.findViewById(R.id.img_produkKopi);
            tvName = itemview.findViewById(R.id.tv_namaKopi);
            tvPrice = itemview.findViewById(R.id.tv_hargaKopi);
            checkBox = itemview.findViewById(R.id.checkBoxKopi);
        }
    }
}
