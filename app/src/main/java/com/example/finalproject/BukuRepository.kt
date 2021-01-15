package com.example.finalproject

import androidx.lifecycle.LiveData
import com.example.finalproject.Database.BukuDao
import com.example.finalproject.Database.data

class BukuRepository(private val bukuDao : BukuDao) {
    val allbuku: LiveData<List<data>> = bukuDao.getData()

    suspend fun insert(Data: data){
        bukuDao.insertbuku(Data)
    }
}