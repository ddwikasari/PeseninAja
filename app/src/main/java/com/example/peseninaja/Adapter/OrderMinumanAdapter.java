package com.example.peseninaja.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.peseninaja.Model.OrderMinuman;
import com.example.peseninaja.R;

import java.util.ArrayList;

public class OrderMinumanAdapter extends RecyclerView.Adapter<OrderMinumanAdapter.ListViewHolder> {
    private ArrayList<OrderMinuman> orderMinumen;

    public OrderMinumanAdapter(ArrayList<OrderMinuman> orderMinumen) {
        this.orderMinumen = orderMinumen;
    }

    @NonNull
    @Override
    public OrderMinumanAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_minuman, parent, false);
        return new OrderMinumanAdapter.ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        OrderMinuman order = orderMinumen.get(position);
        holder.tvName.setText(order.getName());
        holder.tvPrice.setText(order.getPrice());
    }

    @Override
    public int getItemCount() {
        return orderMinumen.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvPrice;

        ListViewHolder(View itemview) {
            super(itemview);
            tvName = itemview.findViewById(R.id.namaMinuman);
            tvPrice = itemview.findViewById(R.id.hargaMinuman);
        }
    }
}
