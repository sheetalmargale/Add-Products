package com.example.addproducts.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;

import com.example.addproducts.R;
import com.example.addproducts.model.Products;
import com.example.addproducts.viewmodel.FromCartViewModel;

import java.util.ArrayList;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder>
{

    Context context;
    RecyclerView recyclerView;
    ArrayList<String> image;
    ArrayList<String> name;
    ArrayList<String> price;
    ArrayList<String> rating;

    private List<Products> productsInCart;

    private CartAdapterOnClickHandler clickHandler;

    private FromCartViewModel fromCartViewModel;

    /**
     * The interface that receives onClick messages.
     */
    public interface CartAdapterOnClickHandler
    {
        void onClick(Products product);
    }

    public CartAdapter(RecyclerView recyclerView, Context context, ArrayList<String> image, ArrayList<String> name, ArrayList<String> price,ArrayList<String> rating)
    {
        this.recyclerView = recyclerView;
        this.context = context;
        this.image = image;
        this.name = name;
        this.price = price;
        this.rating=rating;



        fromCartViewModel = new ViewModelProvider((ViewModelStoreOwner) context).get(FromCartViewModel.class);
    }


    public void update(String images,String names,String prices,String ratings)
    {
        image.add(images);
        name.add(names);
        price.add(prices);
        rating.add(ratings);
        notifyDataSetChanged();  // refreshes the recycler view automatically
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        //View view = LayoutInflater.from(context).inflate(R.layout.cart_item,parent,false);
        //return new ViewHolder(view);

        CartItemBinding cartListItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.product, parent, false);
        return new ViewHolder(cartListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        holder.binding.name.setText(name.get(position));
        holder.binding.price.setText(price.get(position));
        holder.binding.rating.setText(rating.get(position));
        holder.binding.image.setImageResource(image.get(position));

    }

    @Override
    public int getItemCount()
    {
        return name.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView name,price,ratings;
        ImageView image;
        private final CartItemBinding binding;

        public ViewHolder(CartItemBinding binding)
        {
            super(binding.getRoot());
            View itemView = binding.getRoot();

            this.binding = binding;

            name= binding.name;
            price = binding.price;
            rating = binding.rating;
            image = binding.image;

            itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    int position = recyclerView.getChildLayoutPosition(view);

                    Toast.makeText(context, position+"", Toast.LENGTH_SHORT).show();
;
                }
            });
        }
    }
}