package com.example.peseninaja.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.peseninaja.Model.OrderDesert;
import com.example.peseninaja.Model.OrderKopi;
import com.example.peseninaja.R;

import java.util.ArrayList;

public class OrderKopiAdapter extends RecyclerView.Adapter<OrderKopiAdapter.ListViewHolder> {
    private ArrayList<OrderKopi> orderKopi;

    public OrderKopiAdapter(ArrayList<OrderKopi> orderKopi) {
        this.orderKopi = orderKopi;
    }
    @NonNull
    @Override
    public OrderKopiAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_kopi, parent, false);
        return new OrderKopiAdapter.ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderKopiAdapter.ListViewHolder holder, int position) {
        OrderKopi order = orderKopi.get(position);
        holder.tvName.setText(order.getName());
        holder.tvPrice.setText(order.getPrice());

    }

    @Override
    public int getItemCount() {
        return orderKopi.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvPrice;

        ListViewHolder(View itemview) {
            super(itemview);
            tvName = itemview.findViewById(R.id.namaKopi);
            tvPrice = itemview.findViewById(R.id.hargaKopi);
        }
    }
}
