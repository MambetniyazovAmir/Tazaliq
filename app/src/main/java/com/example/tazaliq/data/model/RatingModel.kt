package com.example.tazaliq.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "rating")
data class RatingModel(
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "about")
    var about: String,

    @ColumnInfo(name = "quantity")
    var quantity: Int

) {
}