package com.example.peseninaja.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.peseninaja.Model.OrderDesert;
import com.example.peseninaja.Model.OrderSnack;
import com.example.peseninaja.R;

import java.util.ArrayList;

public class OrderDesertAdapter extends RecyclerView.Adapter<OrderDesertAdapter.ListViewHolder> {
    private ArrayList<OrderDesert> orderDesert;

    public OrderDesertAdapter(ArrayList<OrderDesert> orderDesert) {
        this.orderDesert = orderDesert;
    }
    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_desert, parent, false);
        return new OrderDesertAdapter.ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        OrderDesert order = orderDesert.get(position);
        holder.tvName.setText(order.getName());
        holder.tvPrice.setText(order.getPrice());

    }

    @Override
    public int getItemCount() {
        return orderDesert.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvPrice;

        ListViewHolder(View itemview) {
            super(itemview);
            tvName = itemview.findViewById(R.id.namaDesert);
            tvPrice = itemview.findViewById(R.id.hargaDesert);
        }
    }
}
