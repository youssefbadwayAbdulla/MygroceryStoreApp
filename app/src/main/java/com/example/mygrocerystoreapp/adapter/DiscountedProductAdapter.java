package com.example.mygrocerystoreapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mygrocerystoreapp.R;
import com.example.mygrocerystoreapp.databinding.DiscountedRowBinding;
import com.example.mygrocerystoreapp.model.DiscountedProducts;

import java.util.List;

public class DiscountedProductAdapter extends RecyclerView.Adapter<DiscountedProductAdapter.DiscountedProductHolder> {
Context context;
List<DiscountedProducts>discountedProductsList;

    public DiscountedProductAdapter(Context context, List<DiscountedProducts> discountedProductsList) {
        this.context = context;
        this.discountedProductsList = discountedProductsList;
    }

    @NonNull
    @Override
    public DiscountedProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DiscountedProductHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.discounted_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull DiscountedProductHolder holder, int position) {
        DiscountedProducts discountedProducts=discountedProductsList.get(position);
        holder.binding.discountedImage.setImageResource(discountedProductsList.get(position).getImageUrl());

    }

    @Override
    public int getItemCount() {
     return discountedProductsList.size();

    }

    public class DiscountedProductHolder extends RecyclerView.ViewHolder {
        DiscountedRowBinding binding;
       public DiscountedProductHolder(@NonNull DiscountedRowBinding binding) {
           super(binding.getRoot());
           this.binding=binding;
       }
   }
}
