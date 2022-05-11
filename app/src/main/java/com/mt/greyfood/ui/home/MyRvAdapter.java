package com.mt.greyfood.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mt.greyfood.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

class MyRvAdapter extends RecyclerView.Adapter<MyRvAdapter.MyHolder> {
    ArrayList<String> data;

    public MyRvAdapter(ArrayList<String> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        for (String item : data) {
            Picasso.get().load(item).into(holder.imgView);

        }


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {

        ImageView imgView;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            imgView = itemView.findViewById(R.id.viewImage);
        }
    }

}
