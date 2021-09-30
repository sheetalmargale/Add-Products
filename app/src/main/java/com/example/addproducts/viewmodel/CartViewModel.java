package com.example.addproducts.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.addproducts.model.CartApiResponse;
import com.example.addproducts.repository.CartRepository;

public class CartViewModel extends AndroidViewModel
{
    private CartRepository cartRepository;

    public CartViewModel(@NonNull Application application)
    {
        super(application);
        cartRepository = new CartRepository(application);
    }

    public LiveData<CartApiResponse> getProductsInCart(int id)
    {
        return cartRepository.getProductsInCart(id);
    }
}