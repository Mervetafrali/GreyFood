package com.mt.greyfood.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mt.greyfood.R;
import com.squareup.picasso.Picasso;

import java.util.List;

class MyRvAdapter extends RecyclerView.Adapter<MyRvAdapter.MyHolder> {
    List<String> data;

    public MyRvAdapter(List<String> data) {
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
        Picasso.get().load(data.get(position)).into(holder.imgView);

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
