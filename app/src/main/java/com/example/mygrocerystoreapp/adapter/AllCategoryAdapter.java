package com.example.mygrocerystoreapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mygrocerystoreapp.R;
import com.example.mygrocerystoreapp.databinding.AllCategroyRowBinding;
import com.example.mygrocerystoreapp.model.AllCategoryModel;

import java.util.List;

public class AllCategoryAdapter extends RecyclerView.Adapter<AllCategoryAdapter.AllCategoryProductHolder> {
    List<AllCategoryModel> allCategoryList;
    Context context;

    public AllCategoryAdapter(List<AllCategoryModel> allCategoryList, Context context) {
        this.allCategoryList = allCategoryList;
        this.context = context;
    }

    @NonNull
    @Override
    public AllCategoryProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AllCategoryProductHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.all_categroy_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AllCategoryProductHolder holder, int position) {
        AllCategoryModel allCategoryModel = allCategoryList.get(position);
        holder.binding.allCategoryImage.setImageResource(allCategoryModel.getImageUrl());


    }

    @Override
    public int getItemCount() {
        return allCategoryList.size();
    }

    public class AllCategoryProductHolder extends RecyclerView.ViewHolder {
        AllCategroyRowBinding binding;

        public AllCategoryProductHolder(@NonNull AllCategroyRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
