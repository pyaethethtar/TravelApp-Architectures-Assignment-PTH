package com.example.assignment5.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.assignment5.R
import com.example.assignment5.data.vos.TourVO
import com.example.assignment5.delegates.TourItemDelegate
import com.example.assignment5.view.viewholders.BaseViewHolder
import com.example.assignment5.view.viewholders.CountryViewHolder
import com.example.assignment5.view.viewholders.TourViewHolder

class TourAdapter(delegate: TourItemDelegate): BaseAdapter<BaseViewHolder<TourVO>, TourVO>(){

    val mDelegate:TourItemDelegate=delegate


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<TourVO> {

        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_popular_tours, parent, false)
        return TourViewHolder(view, mDelegate)

    }
}