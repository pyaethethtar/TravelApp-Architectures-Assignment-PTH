package com.example.assignment5.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.assignment5.persistence.typeconverters.PhotoListTypeConverter
import com.example.assignment5.persistence.typeconverters.ScoreReviewListTypeConverter
import com.google.gson.annotations.SerializedName

@Entity(tableName = "tours")
@TypeConverters(ScoreReviewListTypeConverter::class, PhotoListTypeConverter::class)
data class TourVO(
    @PrimaryKey
    @SerializedName("name") var name: String="",
    @SerializedName("description")var description: String="",
    @SerializedName("location")var location: String="",
    @SerializedName("average_rating")var averageRating: Double=0.0,

    @SerializedName("scores_and_reviews") var scoresAndReviews: ArrayList<ScoreReviewVO> = arrayListOf(),
    @SerializedName("photos")var photos: ArrayList<String> = arrayListOf()
    )