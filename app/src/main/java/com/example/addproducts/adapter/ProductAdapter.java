package com.example.addproducts.adapter;


import android.content.Context;
import android.content.Intent;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.addproducts.CartActivity;
import com.example.addproducts.R;
import com.example.addproducts.model.Products;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private ArrayList<Products> productsArrayList;
    private Context mcontext;
    private ArrayList<String> itemList;

    private ArrayList<Integer> selectedList;
    private SparseBooleanArray selectedItems;




    public ProductAdapter(ArrayList<Products> recyclerDataArrayList, Context mcontext) {
        this.productsArrayList = recyclerDataArrayList;

        this.mcontext = mcontext;

    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder  holder, int position) {
        Products products = productsArrayList.get(position);
        holder.name.setText(products.getName());
        holder.price.setText(products.getPrice());
        holder.rating.setText(products.getRating());
        Picasso.get().load(products.getImage_url()).into(holder.image);
        holder.itemView.setActivated(selectedItems.get(position, false));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mcontext, CartActivity.class);
                intent.putExtra("name", (Serializable) products);

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mcontext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {

        return productsArrayList.size();
    }




    public class ProductViewHolder extends RecyclerView.ViewHolder  {
        TextView name,price,rating;
        ImageView image;

        public ProductViewHolder (@NonNull View itemView) {
            super(itemView);

            name = (TextView)itemView.findViewById(R.id.name);
            price = (TextView)itemView.findViewById(R.id.price);
            rating = (TextView)itemView.findViewById(R.id.rating);
            image = (ImageView)itemView.findViewById(R.id.img);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

//                    Intent i=new Intent(view.getContext(),Products.class);
//                    i.putExtra("name",productsArrayList.get(getAdapterPosition()));
                }
            });
        }


    }
}
