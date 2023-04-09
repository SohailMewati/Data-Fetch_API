package com.sohel.laptopdetails.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.sohel.laptopdetails.R
import com.sohel.laptopdetails.model.Products
import org.w3c.dom.Text

class ProductAdapter(var productList: ArrayList<Products>, var context: Context): RecyclerView.Adapter<ProductAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.products, parent, false)
        return MyViewHolder(view)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
      val itemList = productList[position]

        holder.id.text = "Id:  ${productList[position].id}"
        holder.title.text = "Title: ${productList[position].title}"
        holder.category.text = "Category: ${productList[position].category}"
        Glide.with(context).load(productList[position].image).into(holder.image).view
        holder.price.text ="Price: ${ productList[position].price}"
        holder.description.text = "Description:- \n ${productList[position].description}"
    }

    override fun getItemCount(): Int {
       return productList.size
    }

    class MyViewHolder(itemView: View): ViewHolder(itemView) {

        val id: TextView = itemView.findViewById(R.id.txtId)
        val title: TextView = itemView.findViewById(R.id.txtTitle)
        val category: TextView = itemView.findViewById(R.id.txtCategory)
        val image: ImageView = itemView.findViewById(R.id.imgImage)
        val price: TextView = itemView.findViewById(R.id.txtPrice)
        val description: TextView = itemView.findViewById(R.id.txtDescription)


    }
}

