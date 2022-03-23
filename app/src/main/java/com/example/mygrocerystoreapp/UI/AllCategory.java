package com.example.mygrocerystoreapp.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.mygrocerystoreapp.R;
import com.example.mygrocerystoreapp.adapter.AllCategoryAdapter;
import com.example.mygrocerystoreapp.databinding.ActivityAllCategoryBinding;
import com.example.mygrocerystoreapp.model.AllCategoryModel;

import java.util.ArrayList;
import java.util.List;

public class AllCategory extends AppCompatActivity {
    ActivityAllCategoryBinding binding;
    List<AllCategoryModel> allCategoryListModel;
    AllCategoryAdapter categoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_all_category);
        binding.imageViewBack.setOnClickListener(view -> {
            Intent intent=new Intent(AllCategory.this, MainActivity.class);
            startActivity(intent);
            finish();
        });



        allCategoryListModel = new ArrayList<>();
        allCategoryListModel.add(new AllCategoryModel(1, R.drawable.ic_home_fish));
        allCategoryListModel.add(new AllCategoryModel(2, R.drawable.ic_home_fruits));
        allCategoryListModel.add(new AllCategoryModel(3, R.drawable.ic_home_meats));
        allCategoryListModel.add(new AllCategoryModel(4, R.drawable.ic_home_veggies));
        allCategoryListModel.add(new AllCategoryModel(5, R.drawable.ic_drink));
        allCategoryListModel.add(new AllCategoryModel(1, R.drawable.ic_salad));
        allCategoryListModel.add(new AllCategoryModel(2, R.drawable.ic_spices));
        allCategoryListModel.add(new AllCategoryModel(3, R.drawable.ic_juce));
        allCategoryListModel.add(new AllCategoryModel(4, R.drawable.ic_dairy));
        allCategoryListModel.add(new AllCategoryModel(5, R.drawable.ic_cookies));
        allCategoryListModel.add(new AllCategoryModel(1, R.drawable.ic_egg));
        allCategoryListModel.add(new AllCategoryModel(2, R.drawable.ic_desert));

        SetAllCategory(allCategoryListModel);

    }

    private void SetAllCategory(List<AllCategoryModel> allCategoryListModel) {
        categoryAdapter = new AllCategoryAdapter(allCategoryListModel, this);
        RecyclerView.LayoutManager layoutManager=new GridLayoutManager(this,3);
        binding.allCategoryRv.setLayoutManager(layoutManager);
        binding.allCategoryRv.setAdapter(categoryAdapter);

    }
}