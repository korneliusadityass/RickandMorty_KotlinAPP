package com.example.rickandmortyapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RickRecycler : RecyclerView.Adapter<RickRecycler.ViewHolder>() {

    // List of characters to display
    var list = ArrayList<Result>()

    // Set the data for the adapter and
    // notify the RecyclerView of the change
    fun setData(list  : List<Result>){
        this.list = list as ArrayList<Result>
        notifyDataSetChanged()
    }

    // Initialise single item using view holder class
    class ViewHolder(view : View)  : RecyclerView.ViewHolder(view){
        val characterImage = view.characterImage
        val  name = view.showName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_layout,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // loading image using glide library
        Glide.with(holder.itemView).load(list[position].image).into(holder.characterImage)

        // loading character name in text View
        holder.name.text = list[position].name
    }

    override fun getItemCount(): Int {
        return list.size
    }
}