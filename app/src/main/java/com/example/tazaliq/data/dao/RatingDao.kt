package com.example.tazaliq.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.tazaliq.data.model.RatingModel

@Dao
interface RatingDao {

    @Query("SELECT * FROM rating")
    fun getRating(): List<RatingModel>
}