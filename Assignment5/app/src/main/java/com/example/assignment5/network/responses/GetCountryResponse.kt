package com.example.assignment5.network.responses

import com.example.assignment5.data.vos.CountryVO
import com.google.gson.annotations.SerializedName

data class GetCountryResponse(

    @SerializedName("code")val code: Int=0,
    @SerializedName("message")val message: String="",
    @SerializedName("data")val data: ArrayList<CountryVO>?=null
)