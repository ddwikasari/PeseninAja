package com.example.peseninaja.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.peseninaja.Model.OrderMinuman;
import com.example.peseninaja.Model.OrderSnack;
import com.example.peseninaja.R;

import java.util.ArrayList;

public class OrderSnackAdapter extends RecyclerView.Adapter<OrderSnackAdapter.ListViewHolder> {
    private ArrayList<OrderSnack> orderSnacks;

    public OrderSnackAdapter(ArrayList<OrderSnack> orderSnacks) {
        this.orderSnacks = orderSnacks;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_snack, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        OrderSnack order = orderSnacks.get(position);
        holder.tvName.setText(order.getName());
        holder.tvPrice.setText(order.getPrice());

    }

    @Override
    public int getItemCount() {
        return orderSnacks.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvPrice;

        ListViewHolder(View itemview) {
            super(itemview);
            tvName = itemview.findViewById(R.id.namaSnack);
            tvPrice = itemview.findViewById(R.id.hargaSnack);
        }
    }
}
