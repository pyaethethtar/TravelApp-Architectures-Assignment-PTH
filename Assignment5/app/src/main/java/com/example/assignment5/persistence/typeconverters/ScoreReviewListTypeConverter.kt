package com.example.assignment5.persistence.typeconverters

import androidx.room.TypeConverter
import com.example.assignment5.data.vos.ScoreReviewVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ScoreReviewListTypeConverter {

    @TypeConverter
    fun toString(scoreList: ArrayList<ScoreReviewVO>):String{
        return Gson().toJson(scoreList)
    }

    @TypeConverter
    fun toScoreList(scoreListJsonString:String): ArrayList<ScoreReviewVO>{
        val scoreListType= object : TypeToken<ArrayList<ScoreReviewVO>>(){}.type
        return Gson().fromJson(scoreListJsonString, scoreListType)
    }
}