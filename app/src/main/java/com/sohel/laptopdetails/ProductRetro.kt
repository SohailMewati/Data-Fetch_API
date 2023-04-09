package com.sohel.laptopdetails

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProductRetro {

    fun getInstance(): ApiServices {

        return Retrofit.Builder().baseUrl("https://fakestoreapi.com")
             .addConverterFactory(GsonConverterFactory.create()).build()
             .create(ApiServices::class.java)
    }

}