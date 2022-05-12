package com.mt.greyfood.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mt.greyfood.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BrandAdapter extends RecyclerView.Adapter<BrandAdapter.MyHolder> {
    List<String> brand;

    public BrandAdapter(List<String> brand) {
        this.brand = brand;
    }

    @NonNull
    @Override
    public BrandAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_brands, parent, false);
        return new BrandAdapter.MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BrandAdapter.MyHolder holder, int position) {
        Picasso.get().load(brand.get(position)).into(holder.brand);
    }

    @Override
    public int getItemCount() {
        return brand.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {

        ImageView brand;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            brand = itemView.findViewById(R.id.brands);
        }
    }
}
