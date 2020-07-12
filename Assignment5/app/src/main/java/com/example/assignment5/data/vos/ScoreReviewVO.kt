package com.example.assignment5.data.vos

import com.google.gson.annotations.SerializedName

data class ScoreReviewVO (

    @SerializedName("name") var name: String="",
    @SerializedName("score")var score: Double=0.0,
    @SerializedName("max_score")var maxScore: Int=0,
    @SerializedName("total_reviews")var totalReviews: Int=0
)