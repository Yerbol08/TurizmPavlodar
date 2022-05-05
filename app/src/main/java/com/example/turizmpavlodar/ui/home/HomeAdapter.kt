package com.example.turizmpavlodar.ui.home

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.turizmpavlodar.R

class HomeAdapter (private val list: List<HomeItems>, var context: Context): RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val name: TextView = itemView.findViewById(R.id.name)
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val rating: TextView = itemView.findViewById(R.id.rating)
        val price: TextView = itemView.findViewById(R.id.priceTV)
        val ratingBar: RatingBar = itemView.findViewById(R.id.ratingBar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.home_layout, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val items = list[position]
        holder.name.text = items.name
        holder.rating.text = items.rating.toString()
        holder.price.text = items.price
        items.image?.let { holder.imageView.setImageResource(it) }
        holder.ratingBar.numStars = 5
        holder.ratingBar.rating = items.rating.toFloat()
        holder.itemView.setOnClickListener{
            var intent: Intent = Intent(context, HotelActivity::class.java)
            intent.putExtra("name", items.name)
            intent.putExtra("image", items.image)
            intent.putExtra("rating", items.rating)
            intent.putExtra("price", items.price)
            intent.putExtra("position", position)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

}