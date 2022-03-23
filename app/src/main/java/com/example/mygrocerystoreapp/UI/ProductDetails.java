package com.example.mygrocerystoreapp.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.example.mygrocerystoreapp.R;
import com.example.mygrocerystoreapp.databinding.ActivityProductDetailsBinding;

public class ProductDetails extends AppCompatActivity {
    String name,  price, desc;
    ActivityProductDetailsBinding binding;
    int image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_product_details);
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        image = intent.getIntExtra("image",R.drawable.card1);
        price = intent.getStringExtra("price");
        desc = intent.getStringExtra("desc");
        binding.productName.setText(name);
        binding.productPrice.setText(price);
        binding.productDesc.setText(desc);
        binding.ivProductDetails.setImageResource(image);
        binding.mvBack.setOnClickListener(view -> {
            Intent intent1=new Intent(this, MainActivity.class);
            startActivity(intent1);
            finish();
        });

    }
}