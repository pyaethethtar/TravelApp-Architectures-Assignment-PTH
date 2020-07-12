package com.example.assignment5.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.assignment5.data.vos.CountryVO
import com.example.assignment5.data.vos.TourVO

@Dao
interface CountryDao {

    @Query("SELECT * FROM countries")
    fun getAllCountries(): LiveData<List<CountryVO>>

    @Query("SELECT * FROM countries WHERE name= :countryName")
    fun getCountryByName(countryName: String): LiveData<CountryVO>

    @Query("DELETE FROM countries")
    fun deleteAllCountries()

    @Delete
    fun deleteCountry(country: CountryVO)

    @Insert
    fun insertAllCountries(countries: List<CountryVO>)

    @Insert
    fun insertCountry(country: CountryVO)
}