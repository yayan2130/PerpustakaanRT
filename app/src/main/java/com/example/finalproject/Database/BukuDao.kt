package com.example.finalproject.Database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.lifecycle.LiveData as LiveData

@Dao
interface BukuDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertbuku(data: data)

    @Query("SELECT * FROM DATA ORDER BY id ASC")
    fun getData(): LiveData<List<data>>

    @Query("DELETE FROM DATA")
    suspend fun clear()

    @Query("DELETE FROM DATA WHERE id = :idperpus")
    suspend fun deleteBuku(idperpus:Int)
}