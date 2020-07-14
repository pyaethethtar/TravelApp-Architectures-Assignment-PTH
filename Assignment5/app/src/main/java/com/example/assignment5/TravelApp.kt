package com.example.assignment5

import android.app.Application
import com.example.assignment5.data.models.TourModelImpl

class TravelApp: Application(){

    override fun onCreate() {
        super.onCreate()
        TourModelImpl.initDatabase(applicationContext)
    }
}