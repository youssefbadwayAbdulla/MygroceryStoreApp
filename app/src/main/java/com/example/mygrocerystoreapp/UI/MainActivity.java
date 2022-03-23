package com.example.mygrocerystoreapp.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.example.mygrocerystoreapp.R;
import com.example.mygrocerystoreapp.adapter.CategoryAdapter;
import com.example.mygrocerystoreapp.adapter.DiscountedProductAdapter;
import com.example.mygrocerystoreapp.adapter.RecentlyViewAdapter;
import com.example.mygrocerystoreapp.databinding.ActivityMainBinding;
import com.example.mygrocerystoreapp.model.Category;
import com.example.mygrocerystoreapp.model.DiscountedProducts;
import com.example.mygrocerystoreapp.model.RecentlyViewsModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    DiscountedProductAdapter discountedProductAdapter;
    List<DiscountedProducts> discountedProductsList;
    CategoryAdapter categoryAdapter;
    List<Category> categoryList;
    List<RecentlyViewsModel> recentlyViewsModelList;
    RecentlyViewAdapter recentlyViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        //adding data to model
        binding.allCategory.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, AllCategory.class);
            startActivity(intent);
            finish();
        });

        discountedProductsList = new ArrayList<>();
        discountedProductsList.add(new DiscountedProducts(1, R.drawable.discountberry));
        discountedProductsList.add(new DiscountedProducts(2, R.drawable.discountbrocoli));
        discountedProductsList.add(new DiscountedProducts(3, R.drawable.discountmeat));
        discountedProductsList.add(new DiscountedProducts(5, R.drawable.discountberry));
        discountedProductsList.add(new DiscountedProducts(6, R.drawable.discountbrocoli));
        discountedProductsList.add(new DiscountedProducts(7, R.drawable.discountmeat));
        categoryList = new ArrayList<>();
        categoryList.add(new Category(1, R.drawable.ic_home_fish));
        categoryList.add(new Category(2, R.drawable.ic_home_fruits));
        categoryList.add(new Category(3, R.drawable.ic_home_meats));
        categoryList.add(new Category(4, R.drawable.ic_home_veggies));
        categoryList.add(new Category(5, R.drawable.ic_drink));


        //SET recently data

        recentlyViewsModelList = new ArrayList<>();
        recentlyViewsModelList.add(new RecentlyViewsModel("Watermelon",
                "Watermelon has high water content and also provides some fiber.",
                "Price: 25EGP", "1", "KG", R.drawable.card4, R.drawable.card4));
            recentlyViewsModelList.add(new RecentlyViewsModel("Papaya",
                "Watermelon has high water content and also provides some fiber.",
                "Price: 30EGP","1","KG",R.drawable.card3,R.drawable.card3));
        recentlyViewsModelList.add(new RecentlyViewsModel("Strawberry",
                "Watermelon has high water content and also provides some fiber.",
                "Price: 40EGP","1","KG",R.drawable.card2,R.drawable.card2));
        recentlyViewsModelList.add(new RecentlyViewsModel("Kiwi",
                "Watermelon has high water content and also provides some fiber.",
                "Price: 55EGP","2","PC",R.drawable.card1,R.drawable.card1));


        setDisCountedRecycle(discountedProductsList);
        setCategoryRecycle(categoryList);
        SetRecentlyProduct(recentlyViewsModelList);


    }

    private void setDisCountedRecycle(List<DiscountedProducts> discountedProductsList) {
        discountedProductAdapter = new DiscountedProductAdapter(this, discountedProductsList);
        binding.discountRecycler.setAdapter(discountedProductAdapter);
    }

    private void setCategoryRecycle(List<Category> categoryList) {
        categoryAdapter = new CategoryAdapter(categoryList, this);
        binding.categoryRecycler.setAdapter(categoryAdapter);
    }

    private void SetRecentlyProduct(List<RecentlyViewsModel> recentlyViewsModelList) {
        recentlyViewAdapter = new RecentlyViewAdapter(recentlyViewsModelList, this);

        binding.recentlyRecycler.setAdapter(recentlyViewAdapter);

    }

}