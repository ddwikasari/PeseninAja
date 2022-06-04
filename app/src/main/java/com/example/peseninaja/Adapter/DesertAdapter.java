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
import com.example.peseninaja.Model.OrderDesert;
import com.example.peseninaja.Model.OrderSnack;
import com.example.peseninaja.Model.Snack;
import com.example.peseninaja.R;

import java.util.ArrayList;

public class DesertAdapter extends RecyclerView.Adapter<DesertAdapter.ListViewHolder> {

    private ArrayList<Desert> listDesert;
    private ArrayList<OrderDesert> pilihDesert;

    public DesertAdapter(ArrayList<Desert> listDesert) {
        this.listDesert = listDesert;
        pilihDesert = new ArrayList<>();
    }

    public ArrayList<OrderDesert> getCheckedDesert() {
        return pilihDesert;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ui_desert, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DesertAdapter.ListViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Desert desert = listDesert.get(position);
        Glide.with(holder.itemView.getContext())
                .load(desert.getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgPhoto);
        holder.tvName.setText(desert.getName());
        holder.tvPrice.setText(desert.getPrice());
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    OrderDesert order = new OrderDesert(listDesert.get(position).getName(), listDesert.get(position).getPrice());
                    pilihDesert.add(order);
                }else{
                    for(int i = 0; i < pilihDesert.size(); i++) {
                        if(pilihDesert.get(i).getName() == listDesert.get(position).getName() && pilihDesert.get(i).getPrice() == listDesert.get(position).getPrice()){
                            pilihDesert.remove(i);
                        }
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listDesert.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName;
        TextView tvPrice;
        CheckBox checkBox;

        ListViewHolder(View itemview) {
            super(itemview);
            imgPhoto = itemview.findViewById(R.id.img_produkDesert);
            tvName = itemview.findViewById(R.id.tv_namaDesert);
            tvPrice = itemview.findViewById(R.id.tv_hargaDesert);
            checkBox = itemview.findViewById(R.id.checkBoxDesert);
        }
    }
}
