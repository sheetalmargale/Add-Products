package com.example.addproducts;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.addproducts.adapter.CartAdapter;
import com.example.addproducts.model.Products;
import com.example.addproducts.viewmodel.CartViewModel;

import java.util.ArrayList;
import java.util.List;

public class AddCartActivity extends AppCompatActivity {
//    CartBinding cartBinding;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    Button checkout;
    CartViewModel cartViewModel;
    CartAdapter cartAdapter;

    private List<Products> favoriteList;
    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cart);

        Toolbar  toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getWindow().setStatusBarColor(getResources().getColor(R.color.white, getTheme()));
        recyclerView=findViewById(R.id.recyclerview);
        checkout=findViewById(R.id.button);

//        recyclerView = cartBinding.recyclerview;
//        checkout = cartBinding.checkout;

        setUpRecyclerView();
        getProductsInCart();

        checkout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AddCartActivity.this, OderActivity.class);
                startActivity(intent);
            }
        });
    }
    private void setUpRecyclerView()
    {
        linearLayoutManager = new LinearLayoutManager(AddCartActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        // cartBinding.recyclerview.setHasFixedSize(true);
        cartViewModel = new ViewModelProvider(this).get(CartViewModel.class);
    }

    private void getProductsInCart()
    {
        cartAdapter = new CartAdapter(recyclerView,AddCartActivity.this,new ArrayList<String>(),new ArrayList<String>(),new ArrayList<String>(),new ArrayList<String>());


        cartAdapter.update(String.valueOf(R.drawable.ic_launcher_background),"Samsung","₹300.00","5");
        cartAdapter.update(String.valueOf(R.drawable.ic_launcher_background),"iphone","₹500.00","4");

//        cartBinding.recyclerview.setAdapter(cartAdapter);
        cartAdapter.notifyDataSetChanged();

    }
}