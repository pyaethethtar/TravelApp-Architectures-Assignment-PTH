package com.example.assignment5.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.assignment5.data.vos.TourVO

@Dao
interface TourDao {

    @Query("SELECT * FROM tours")
    fun getAllTours(): LiveData<List<TourVO>>

    @Query("SELECT * FROM tours WHERE name= :tourName")
    fun getTourByName(tourName: String): LiveData<TourVO>

    @Query("DELETE FROM tours")
    fun deleteAllTours()

    @Delete
    fun deleteTour(tour: TourVO)

    @Insert
    fun insertAllTours(tours: List<TourVO>)

    @Insert
    fun insertTour(tour: TourVO)

}