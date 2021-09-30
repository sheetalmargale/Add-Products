package com.example.addproducts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.addproducts.adapter.ProductAdapter;
import com.example.addproducts.api.ApiService;
import com.example.addproducts.model.Products;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    private final int count = 0;
    private ProgressBar progressBar;
    public ImageView cart;
    private ArrayList<Products> productsArrayList;
    private ProductAdapter productsAdapter;




    public RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        productsArrayList = new ArrayList<>();
        cart.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,CartActivity.class);
            startActivity(intent);
        });
        


        getAllProducts();

    }


    private void getAllProducts() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://my-json-server.typicode.com/nancymadan/assignment/")

                .addConverterFactory(GsonConverterFactory.create())

                .build();

        ApiService retrofitAPI = retrofit.create(ApiService.class);


        Call<ArrayList<Products>> call = retrofitAPI.getAllProducts();

        call.enqueue(new Callback<ArrayList<Products>>() {
            @Override
            public void onResponse(Call<ArrayList<Products>> call, Response<ArrayList<Products>> response) {

                if (response.isSuccessful()) {


                    progressBar.setVisibility(View.GONE);

                    productsArrayList = response.body();

                    // below line we are running a loop to add data to our adapter class.
                    for (int i = 0; i < productsArrayList.size(); i++) {
                        productsAdapter = new ProductAdapter(productsArrayList, MainActivity.this);

                        // below line is to set layout manager for our recycler view.
                        LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this);

                        recyclerView.setLayoutManager(manager);


                        recyclerView.setAdapter(productsAdapter);
                    }
                }
            }


            @Override
            public void onFailure(Call<ArrayList<Products>> call, Throwable t) {

                Toast.makeText(MainActivity.this, "Fail to get data", Toast.LENGTH_SHORT).show();
            }
        });

    }
}