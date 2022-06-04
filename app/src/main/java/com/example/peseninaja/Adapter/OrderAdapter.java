package com.example.peseninaja.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.peseninaja.Model.OrderMakanan;
import com.example.peseninaja.R;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ListViewHolder> {
    private ArrayList<OrderMakanan> orderMakanan;

    public OrderAdapter(ArrayList<OrderMakanan> orderMakanan) {
        this.orderMakanan = orderMakanan;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        OrderMakanan order = orderMakanan.get(position);
        holder.tvName.setText(order.getName());
        holder.tvPrice.setText(order.getPrice());
    }

    @Override
    public int getItemCount() {
        return orderMakanan.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvPrice;

        ListViewHolder(View itemview) {
            super(itemview);
            tvName = itemview.findViewById(R.id.tv_nama1);
            tvPrice = itemview.findViewById(R.id.tv_harga1);
        }
    }
}
