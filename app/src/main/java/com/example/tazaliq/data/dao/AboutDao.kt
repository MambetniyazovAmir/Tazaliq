package com.example.tazaliq.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.tazaliq.data.model.AboutModel

@Dao
interface AboutDao {

    @Query("SELECT * FROM about")
    fun getAboutList(): List<AboutModel>
}