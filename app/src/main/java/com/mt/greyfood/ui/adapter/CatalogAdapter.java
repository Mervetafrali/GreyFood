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

public class CatalogAdapter extends RecyclerView.Adapter<CatalogAdapter.MyHolder> {
    List<String> catalog;

    public CatalogAdapter(List<String> catalog) {
        this.catalog = catalog;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_catalog, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        Picasso.get().load(catalog.get(position)).into(holder.catalog);
    }

    @Override
    public int getItemCount() {
        return catalog.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {

        ImageView catalog;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            catalog = itemView.findViewById(R.id.catalog);
        }
    }

}
