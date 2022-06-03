package com.example.peseninaja;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class MakananAdapter extends RecyclerView.Adapter<MakananAdapter.ListViewHolder> {
    private ArrayList<Makanan> listMakanan;
    AdapterView.OnItemClickListener mListener;
    int count=0;

    public MakananAdapter(ArrayList<Makanan> list) {
        this.listMakanan = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ui_makanan, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Makanan makanan = listMakanan.get(position);
        Glide.with(holder.itemView.getContext())
                .load(makanan.getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgPhoto);
        holder.tvName.setText(makanan.getName());
        holder.tvDesc.setText(makanan.getDesc());
        holder.tvPrice.setText(String.valueOf(makanan.getPrice()));
        holder.tvCount.setText(String.valueOf(makanan.getCount()));

        holder.buttonDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count= Integer.parseInt(String.valueOf(holder.tvCount.getText()));
                if(count>0){
                    count--;
                    holder.tvCount.setText(String.valueOf(count));
                }
            }
        });

        holder.buttonInc.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                int count= Integer.parseInt(String.valueOf(holder.tvCount.getText()));
                count++;
                holder.tvCount.setText(String.valueOf(count));
            }

        });

    }

    @Override
    public int getItemCount() {
        return listMakanan.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDesc, tvPrice, tvCount;
        Button buttonInc, buttonDec;

        ListViewHolder(View itemview) {
            super(itemview);
            imgPhoto = itemview.findViewById(R.id.img_produk);
            tvName = itemview.findViewById(R.id.tv_nama);
            tvDesc = itemview.findViewById(R.id.tv_desc);
            tvPrice = itemview.findViewById(R.id.tv_harga);
            tvCount = itemview.findViewById(R.id.itemCount);
            buttonInc = itemview.findViewById(R.id.itemAdd);
            buttonDec = itemview.findViewById(R.id.itemRemove);
        }
    }

}