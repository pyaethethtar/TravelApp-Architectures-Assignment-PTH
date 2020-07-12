package com.example.assignment5.network.responses

import com.example.assignment5.data.vos.TourVO
import com.example.assignment5.utils.CODE_RESPONSE_OK
import com.google.gson.annotations.SerializedName

data class GetTourResponse(

    @SerializedName("code")val code: Int=0,
    @SerializedName("message")val message: String="",
    @SerializedName("data")val data: ArrayList<TourVO>?=null
){
    fun isResponseOk():Boolean=(data!=null && code== CODE_RESPONSE_OK)
}