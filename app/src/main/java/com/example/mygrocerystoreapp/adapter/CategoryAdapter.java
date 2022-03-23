package com.example.mygrocerystoreapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mygrocerystoreapp.R;
import com.example.mygrocerystoreapp.databinding.CategroyRowBinding;
import com.example.mygrocerystoreapp.databinding.DiscountedRowBinding;
import com.example.mygrocerystoreapp.model.Category;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryProductHolder> {
    List<Category> categoryList;
    Context context;

    public CategoryAdapter(List<Category> categoryList, Context context) {
        this.categoryList = categoryList;
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CategoryProductHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.categroy_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryProductHolder holder, int position) {
        Category category = categoryList.get(position);
        holder.binding.categoryImage.setImageResource(category.getImageUrl());

    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class CategoryProductHolder extends RecyclerView.ViewHolder {
        CategroyRowBinding binding;

        public CategoryProductHolder(@NonNull CategroyRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
