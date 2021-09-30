package com.example.addproducts.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CartApiResponse
{
    @SerializedName("carts")
    private List<Products> carts;

    public List<Products> getProductsInCart()
    {
        return carts;
    }

    public void setProductsInCart(List<Products> carts)
    {
        this.carts = carts;
    }
}