package com.example.assignment5.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment5.R
import com.example.assignment5.view.viewholders.TourImagesViewHolder

class TourImagesAdapter: RecyclerView.Adapter<TourImagesViewHolder>() {

    var imageList:MutableList<String> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TourImagesViewHolder {
        val view=
            LayoutInflater.from(parent.context).inflate(R.layout.item_tour_images, parent, false)
        return TourImagesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return imageList.count()
    }

    override fun onBindViewHolder(holder: TourImagesViewHolder, position: Int) {
        holder.bindImage(imageList[position])
    }

    fun setTourImages(data: List<String>){
        imageList.clear()
        imageList.addAll(data)
        notifyDataSetChanged()
    }
}