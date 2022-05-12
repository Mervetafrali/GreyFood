package com.mt.greyfood.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mt.greyfood.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.MyHolder> {

    List<Categori> categoris;

    public CategoriesAdapter(List<Categori> categoris) {
        this.categoris = categoris;
    }

    @NonNull
    @Override
    public CategoriesAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_categories, parent, false);
        return new CategoriesAdapter.MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesAdapter.MyHolder holder, int position) {
        holder.text.setText(categoris.get(position).getImageText());
        Picasso.get().load(categoris.get(position).getImageUrl()).into(holder.category);
    }

    @Override
    public int getItemCount() {
        return categoris.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {

        ImageView category;
        TextView text;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            category = itemView.findViewById(R.id.itemImg);
            text = itemView.findViewById(R.id.itemName);
        }
    }
}