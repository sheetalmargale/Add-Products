package com.example.addproducts.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.addproducts.repository.FromCartRepository;

public class FromCartViewModel extends AndroidViewModel
{
    private FromCartRepository fromCartRepository;

    public FromCartViewModel(@NonNull Application application)
    {
        super(application);
        fromCartRepository = new FromCartRepository(application);
    }


}