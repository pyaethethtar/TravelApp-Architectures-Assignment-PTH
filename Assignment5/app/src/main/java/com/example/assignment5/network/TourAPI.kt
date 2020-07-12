package com.example.assignment5.network

import com.example.assignment5.network.responses.GetCountryResponse
import com.example.assignment5.network.responses.GetTourResponse
import com.example.assignment5.utils.GET_COUNTRIES
import com.example.assignment5.utils.GET_TOURS
import com.example.assignment5.utils.PARAM_ACCESS_TOKEN
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET

interface TourAPI {


    @GET(GET_TOURS)
    fun getAllTours(): Observable<GetTourResponse>

    @GET(GET_COUNTRIES)
    fun getAllCountries(): Observable<GetCountryResponse>
}