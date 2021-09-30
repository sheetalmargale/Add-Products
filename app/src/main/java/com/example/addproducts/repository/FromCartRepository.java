package com.example.addproducts.repository;

import android.app.Application;

public class FromCartRepository
{
    private static final String TAG = FromCartRepository.class.getSimpleName();
    private Application application;

    public FromCartRepository(Application application)
    {
        this.application = application;
    }


}