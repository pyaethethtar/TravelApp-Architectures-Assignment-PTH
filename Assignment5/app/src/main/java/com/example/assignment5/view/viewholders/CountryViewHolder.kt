package com.example.assignment5.view.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.example.assignment5.data.vos.CountryVO
import com.example.assignment5.data.vos.TourVO
import com.example.assignment5.delegates.TourItemDelegate
import kotlinx.android.synthetic.main.item_countries.view.*

class CountryViewHolder(itemView: View, private val delegate: TourItemDelegate): BaseViewHolder<CountryVO>(itemView) {

    lateinit var name: String

    override fun bindData(data: CountryVO) {
        Glide.with(itemView.context).load(data.photos[0]).into(itemView.ivCountry)
        itemView.tvRating.text=data.averageRating.toString()
        name=data.name

        itemView.setOnClickListener {
            delegate.onTapItem(name)
        }
    }

    override fun bindImage(image: String) {

    }
}