package com.example.finalproject.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [data::class], version = 1, exportSchema = false)
abstract class perpusRoomDB : RoomDatabase() {
    abstract fun BukuDao() : BukuDao

    companion object {
        @Volatile
        private var INSTANCE: perpusRoomDB? = null

        fun getDatabase(context: Context): perpusRoomDB {
            val tempInstance = INSTANCE

            synchronized(this) {
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        perpusRoomDB::class.java,
                        "toko_jago_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}