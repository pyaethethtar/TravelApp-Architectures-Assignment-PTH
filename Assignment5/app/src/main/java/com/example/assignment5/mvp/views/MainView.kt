package com.example.assignment5.mvp.views

import com.example.assignment5.data.vos.CountryVO
import com.example.assignment5.data.vos.TourVO

interface MainView : BaseView{

    fun displayTours(tours: List<TourVO>)
    fun displayCountries(countries: List<CountryVO>)
    fun navigatetoTourDetails(name: String)
}