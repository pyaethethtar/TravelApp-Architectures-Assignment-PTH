package com.example.assignment5.mvp.views

import com.example.assignment5.data.vos.CountryVO
import com.example.assignment5.data.vos.TourVO

interface DetailsView: BaseView {

    fun displayTourDetails(tour: TourVO)
    fun displayCountryDetails(country: CountryVO)
}