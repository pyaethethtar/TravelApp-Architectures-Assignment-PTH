package com.example.assignment5.view.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.example.assignment5.data.vos.TourVO
import kotlinx.android.synthetic.main.item_tour_images.view.*

class TourImagesViewHolder(itemView:View): BaseViewHolder<TourVO>(itemView) {
    override fun bindData(data: TourVO) {

    }

    override fun bindImage(image: String) {
        Glide.with(itemView.context).load(image).into(itemView.ivTourImages)
    }
}