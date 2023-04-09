package com.sohel.laptopdetails

import com.sohel.laptopdetails.model.Products
import retrofit2.Response
import retrofit2.http.GET

interface ApiServices {

    @GET("/products")  //End point

    suspend fun getProductDetails(): Response<List<Products>>
}