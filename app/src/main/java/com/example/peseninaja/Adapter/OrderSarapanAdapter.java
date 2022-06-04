package com.example.peseninaja.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.peseninaja.Model.OrderKopi;
import com.example.peseninaja.Model.OrderSarapan;
import com.example.peseninaja.R;

import java.util.ArrayList;

public class OrderSarapanAdapter extends RecyclerView.Adapter<OrderSarapanAdapter.ListViewHolder> {
    private ArrayList<OrderSarapan> orderSarapan;

    public OrderSarapanAdapter(ArrayList<OrderSarapan> orderSarapan) {
        this.orderSarapan = orderSarapan;
    }
    @NonNull
    @Override
    public OrderSarapanAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_sarapan, parent, false);
        return new OrderSarapanAdapter.ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderSarapanAdapter.ListViewHolder holder, int position) {
        OrderSarapan order = orderSarapan.get(position);
        holder.tvName.setText(order.getName());
        holder.tvPrice.setText(order.getPrice());

    }

    @Override
    public int getItemCount() {
        return orderSarapan.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvPrice;

        ListViewHolder(View itemview) {
            super(itemview);
            tvName = itemview.findViewById(R.id.namaSarapan);
            tvPrice = itemview.findViewById(R.id.hargaSarapan);
        }
    }
}
