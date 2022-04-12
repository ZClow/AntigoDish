package com.example.login

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class BuyAdapter(private var productList: MutableList<Product>): RecyclerView.Adapter<BuyAdapter.BuyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuyAdapter.BuyViewHolder {
        val layoutView: View = LayoutInflater.from(parent.context).inflate(R.layout.buy_card_view, parent, false)
    return BuyViewHolder(layoutView)
    }

    override fun onBindViewHolder(holder: BuyAdapter.BuyViewHolder, position: Int) {
        Picasso.get().load(productList[position].image)
            .into(holder.prodImage)
        holder.prodName.text = productList[position].title
        holder.prodPrice.text = productList[position].price
    }

    override fun getItemCount(): Int {
        return 4
    }

    class BuyViewHolder(view: View): RecyclerView.ViewHolder(view){
        var prodImage: ImageView = view.findViewById(R.id.prod_img)
        var prodName: TextView = view.findViewById(R.id.prod_title)
        var prodDesc : TextView = view.findViewById(R.id.prod_desc)
        var prodPrice : TextView = view.findViewById(R.id.prod_price)
    }
}