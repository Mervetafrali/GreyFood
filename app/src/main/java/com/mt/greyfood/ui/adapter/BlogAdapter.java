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

public class BlogAdapter extends RecyclerView.Adapter<BlogAdapter.MyHolder> {
    List<String> blog;

    public BlogAdapter(List<String> blog) {
        this.blog = blog;
    }

    @NonNull
    @Override
    public BlogAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_blog, parent, false);
        return new BlogAdapter.MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BlogAdapter.MyHolder holder, int position) {
        Picasso.get().load(blog.get(position)).into(holder.blog);
    }

    @Override
    public int getItemCount() {
        return blog.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {

        ImageView blog;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            blog = itemView.findViewById(R.id.blog);
        }
    }

}
