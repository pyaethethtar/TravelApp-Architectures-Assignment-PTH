package com.example.assignment5.view.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.example.assignment5.data.vos.TourVO
import com.example.assignment5.delegates.TourItemDelegate
import kotlinx.android.synthetic.main.item_countries.view.tvRating
import kotlinx.android.synthetic.main.item_popular_tours.view.*

class TourViewHolder(itemView: View, private val delegate: TourItemDelegate): BaseViewHolder<TourVO>(itemView) {

    lateinit var name: String

    override fun bindData(data: TourVO) {
        name=data.name
        itemView.tvRating.text=data.averageRating.toString()
        Glide.with(itemView.context).load(data.photos[0]).into(itemView.ivTour)

        itemView.setOnClickListener {
            delegate.onTapItem(name)
        }
    }

    override fun bindImage(image: String) {

    }


}