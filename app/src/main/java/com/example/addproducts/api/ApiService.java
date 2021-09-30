package com.example.addproducts.api;

import com.example.addproducts.model.CartApiResponse;
import com.example.addproducts.model.Products;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

        @GET("products")
//        Call<List<Cart>> getCartList();
        Call<ArrayList<Products>> getAllProducts();
        @GET("carts")
        Call<CartApiResponse> getProductsInCart(@Query("id") int id);

}
