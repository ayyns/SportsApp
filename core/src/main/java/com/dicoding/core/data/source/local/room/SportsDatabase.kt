package com.dicoding.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dicoding.core.data.source.local.entity.SportsEntity

@Database(entities = [SportsEntity::class], version = 9, exportSchema = false)
abstract class SportsDatabase : RoomDatabase() {

    abstract fun tourismDao(): SportsDao

}