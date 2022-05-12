package com.mt.greyfood.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mt.greyfood.R;
import com.mt.greyfood.ui.home.SnackModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SnackAdapter extends RecyclerView.Adapter<SnackAdapter.ViewHolder> {

    List<SnackModel> snackItems;
    private final Context context;

    public SnackAdapter(List<SnackModel> itemList, Context context) {
        this.snackItems = itemList;
        this.context = context;

    }

    @NonNull
    @Override
    public SnackAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.snack_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SnackAdapter.ViewHolder holder, final int position) {

        Picasso.get().load(snackItems.get(position).getSnackImageUrl()).into(holder.snackItemImage);
        holder.snackItemText.setText(snackItems.get(position).getSnackImageText());


    }

    @Override
    public int getItemCount() {
        return snackItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView snackItemImage;
        TextView snackItemText;
        LinearLayout linearLayout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            snackItemImage = itemView.findViewById(R.id.snack_item_img);
            snackItemText = itemView.findViewById(R.id.snack_item_text);
            linearLayout = itemView.findViewById(R.id.layout_id);

        }
    }
}