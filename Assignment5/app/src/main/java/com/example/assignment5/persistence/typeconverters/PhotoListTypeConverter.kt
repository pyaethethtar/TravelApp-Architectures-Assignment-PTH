package com.example.assignment5.persistence.typeconverters

import androidx.room.TypeConverter
import com.example.assignment5.data.vos.ScoreReviewVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class PhotoListTypeConverter {

    @TypeConverter
    fun toString(photoList: ArrayList<String>):String{
        return Gson().toJson(photoList)
    }

    @TypeConverter
    fun toPhotoList(photoListJsonString:String): ArrayList<String>{
        val photoListType= object : TypeToken<ArrayList<String>>(){}.type
        return Gson().fromJson(photoListJsonString, photoListType)
    }
}