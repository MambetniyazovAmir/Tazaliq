package com.example.tazaliq.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tazaliq.data.dao.AboutDao
import com.example.tazaliq.data.model.AboutModel

@Database(
    entities =[AboutModel::class],
    version = 1,
    exportSchema = false
)
abstract class TazaliqDatabase: RoomDatabase() {

    abstract fun aboutDao(): AboutDao

}