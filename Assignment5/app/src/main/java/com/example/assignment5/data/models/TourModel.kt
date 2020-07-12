package com.example.assignment5.data.models

import androidx.lifecycle.LiveData
import com.example.assignment5.data.vos.CountryVO
import com.example.assignment5.data.vos.MainVO
import com.example.assignment5.data.vos.TourVO
import io.reactivex.Observable

interface TourModel {

    fun getAllTours(onError:(String)-> Unit): LiveData<List<TourVO>>
    fun getAllCountries(onError:(String)-> Unit): LiveData<List<CountryVO>>

    fun getToursAndCountries(): Observable<MainVO>

    fun getAllToursByName(name: String): LiveData<TourVO>

    fun getAllCountryByName(name: String) : LiveData<CountryVO>

}