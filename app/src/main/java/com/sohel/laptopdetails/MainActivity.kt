package com.sohel.laptopdetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sohel.laptopdetails.adapter.ProductAdapter
import com.sohel.laptopdetails.model.Products
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val productList: ArrayList<Products> = ArrayList()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val recyclerAdapter = ProductAdapter(productList, this)
        recyclerView.adapter = recyclerAdapter

        GlobalScope.launch(Dispatchers.Default) {

            val apiService = ProductRetro().getInstance()
            val data = apiService.getProductDetails()

            if (data.isSuccessful){
                val result = data.body()

                GlobalScope.launch(Dispatchers.Main){
                    if (result != null){
                        productList.addAll(result)
                    }
                    recyclerAdapter.notifyDataSetChanged()
                    Log.e("Sohail", result.toString())
                }
                //Log.e("Sohail", result.toString())
            } /*else{
                Log.e("api failed", "Api is failed")
            }*/

        }
    }
}