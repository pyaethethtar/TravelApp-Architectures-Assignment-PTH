package com.example.assignment5.data.models

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.assignment5.data.vos.CountryVO
import com.example.assignment5.data.vos.MainVO
import com.example.assignment5.data.vos.TourVO
import com.example.assignment5.persistence.db.TourDB
import com.example.assignment5.utils.EM_NO_INTERNET_CONNECTION
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers

object TourModelImpl : BaseModel(), TourModel{


    override fun getAllTours(onError: (String) -> Unit): LiveData<List<TourVO>> {

        //getAllToursFromApiAndSaveToDatabase(onError)
        return mTheDB.tourDao().getAllTours()

    }

    override fun getAllCountries(onError: (String) -> Unit): LiveData<List<CountryVO>> {
        //getAllCountriesFromApiAndSaveToDatabase(onError)
        return mTheDB.countryDao().getAllCountries()
    }

//    @SuppressLint("CheckResult")
//    private fun getAllToursFromApiAndSaveToDatabase(onError: (String) -> Unit){
//
//        toursObservable
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                mTheDB.tourDao().insertAllTours(it)
//            },{
//                onError(it.localizedMessage?: EM_NO_INTERNET_CONNECTION)
//            })
//    }

//    @SuppressLint("CheckResult")
//    private fun getAllCountriesFromApiAndSaveToDatabase(onError: (String) -> Unit){
//
//        countriesObservable
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                mTheDB.countryDao().insertAllCountries(it)
//            },{
//                onError(it.localizedMessage?: EM_NO_INTERNET_CONNECTION)
//            })
//    }


    override fun getAllToursByName(name: String): LiveData<TourVO> {
        return mTheDB.tourDao().getTourByName(name)
    }

    override fun getAllCountryByName(name: String): LiveData<CountryVO> {
        return mTheDB.countryDao().getCountryByName(name)
    }







}