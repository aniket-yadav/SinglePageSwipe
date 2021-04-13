package com.example.singlepageswipe

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

 class ViewpagerAdaptor(val context: Context, val images:MutableList<Int>):RecyclerView.Adapter<ViewpagerAdaptor.ViewHolder>() {
    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val imageView = itemView.findViewById<ImageView>(R.id.image)
    }

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
         val inflater = LayoutInflater.from(parent.context)
         val itemView = inflater.inflate(R.layout.image_layout,parent,false)
         return ViewHolder(itemView)
     }

     override fun onBindViewHolder(holder: ViewHolder, position: Int) {
         holder.imageView.setImageResource(images[position])
     }

     override fun getItemCount(): Int {
         return images.size
     }
 }