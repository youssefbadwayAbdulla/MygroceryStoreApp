package com.example.mygrocerystoreapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mygrocerystoreapp.UI.ProductDetails;
import com.example.mygrocerystoreapp.R;
import com.example.mygrocerystoreapp.databinding.RecentlyViewIteamsBinding;
import com.example.mygrocerystoreapp.model.RecentlyViewsModel;

import java.util.List;


public class RecentlyViewAdapter extends RecyclerView.Adapter<RecentlyViewAdapter.RecentlyViewHolder> {
    List<RecentlyViewsModel> recentlyViewsModelList;
    Context context;

    public RecentlyViewAdapter(List<RecentlyViewsModel> recentlyViewsModelList, Context context) {
        this.recentlyViewsModelList = recentlyViewsModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecentlyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecentlyViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.recently_view_iteams, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecentlyViewHolder holder, int position) {
        RecentlyViewsModel recentlyViewsModel = recentlyViewsModelList.get(position);
        holder.binding.ProductName.setText(recentlyViewsModelList.get(position).getName());
        holder.binding.description.setText(recentlyViewsModelList.get(position).getDescription());
        holder.binding.price.setText(recentlyViewsModelList.get(position).getPrice());
        holder.binding.qty.setText(recentlyViewsModelList.get(position).getQuantity());
        holder.binding.unit.setText(recentlyViewsModelList.get(position).getUnit());
        holder.binding.layoutRecentlyView.setBackgroundResource(recentlyViewsModelList.get(position).getImageUrl());
        holder.itemView.setOnClickListener(view -> {
            Intent intent=new Intent(context, ProductDetails.class);
            intent.putExtra("name",recentlyViewsModelList.get(position).getName());
            intent.putExtra("image",recentlyViewsModelList.get(position).getBigImageUrl());
            intent.putExtra("price",recentlyViewsModelList.get(position).getPrice());
            intent.putExtra("desc",recentlyViewsModelList.get(position).getDescription());
            context.startActivity(intent);
        });


    }

    @Override
    public int getItemCount() {
        return recentlyViewsModelList.size();
    }

    public class RecentlyViewHolder extends RecyclerView.ViewHolder {
        RecentlyViewIteamsBinding binding;

        public RecentlyViewHolder(@NonNull RecentlyViewIteamsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
