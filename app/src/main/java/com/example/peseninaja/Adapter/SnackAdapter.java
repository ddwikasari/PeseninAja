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
import com.example.peseninaja.Model.OrderSnack;
import com.example.peseninaja.Model.Snack;
import com.example.peseninaja.R;

import java.util.ArrayList;

public class SnackAdapter extends RecyclerView.Adapter<SnackAdapter.ListViewHolder> {

    private ArrayList<Snack> listSnack;
    private ArrayList<OrderSnack> pilihSnack;

    public SnackAdapter(ArrayList<Snack> listSnack) {
        this.listSnack = listSnack;
        pilihSnack = new ArrayList<>();
    }

    public ArrayList<OrderSnack> getCheckedSnack() {
        return pilihSnack;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ui_snack, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SnackAdapter.ListViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Snack snack = listSnack.get(position);
        Glide.with(holder.itemView.getContext())
                .load(snack.getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgPhoto);
        holder.tvName.setText(snack.getName());
        holder.tvPrice.setText(snack.getPrice());
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    OrderSnack order = new OrderSnack(listSnack.get(position).getName(), listSnack.get(position).getPrice());
                    pilihSnack.add(order);
                }else{
                    for(int i = 0; i < pilihSnack.size(); i++) {
                        if(pilihSnack.get(i).getName() == listSnack.get(position).getName() && pilihSnack.get(i).getPrice() == listSnack.get(position).getPrice()){
                            pilihSnack.remove(i);
                        }
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listSnack.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName;
        TextView tvPrice;
        CheckBox checkBox;

        ListViewHolder(View itemview) {
            super(itemview);
            imgPhoto = itemview.findViewById(R.id.img_produkSnack);
            tvName = itemview.findViewById(R.id.tv_namaSnack);
            tvPrice = itemview.findViewById(R.id.tv_hargaSnack);
            checkBox = itemview.findViewById(R.id.checkBoxSnack);
        }
    }
}
