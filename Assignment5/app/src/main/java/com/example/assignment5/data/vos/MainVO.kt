package com.example.assignment5.data.vos

data class MainVO(
    val country: List<CountryVO> = arrayListOf(),
    val tour: List<TourVO> = arrayListOf()
)