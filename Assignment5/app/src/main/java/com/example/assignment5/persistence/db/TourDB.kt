package com.example.assignment5.persistence.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.assignment5.data.vos.CountryVO
import com.example.assignment5.data.vos.TourVO
import com.example.assignment5.persistence.daos.CountryDao
import com.example.assignment5.persistence.daos.TourDao

@Database(entities = [TourVO::class, CountryVO::class], version = 2)
abstract class TourDB : RoomDatabase() {

    companion object{

        val DB_NAME = "TOUR_DB"
        var dbInstance:TourDB?=null

        fun getDBInstance(context: Context):TourDB{
            when(dbInstance){
                null -> {
                    dbInstance = Room.databaseBuilder(context, TourDB::class.java, DB_NAME)
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            val i= dbInstance
            return i!!
        }
    }

    abstract fun tourDao(): TourDao
    abstract fun countryDao(): CountryDao
}