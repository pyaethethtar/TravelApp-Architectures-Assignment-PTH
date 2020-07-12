package com.example.assignment5.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.assignment5.R
import com.example.assignment5.data.vos.CountryVO
import com.example.assignment5.delegates.TourItemDelegate
import com.example.assignment5.view.viewholders.BaseViewHolder
import com.example.assignment5.view.viewholders.CountryViewHolder

class CountryAdapter(delegate: TourItemDelegate): BaseAdapter<BaseViewHolder<CountryVO>, CountryVO>() {

    val mDelegate=delegate

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<CountryVO> {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_countries, parent, false)
        return CountryViewHolder(view, mDelegate)
    }
}