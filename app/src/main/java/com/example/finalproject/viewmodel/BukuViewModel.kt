package com.example.finalproject.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.finalproject.BukuRepository
import com.example.finalproject.Database.data
import com.example.finalproject.Database.perpusRoomDB

class BukuViewModel(application: Application) : AndroidViewModel(application){
    private val repository : BukuRepository
    private val allBuku: LiveData<List<data>>

    init {
        val BukuDao = perpusRoomDB.getDatabase(application).BukuDao()
        repository = BukuRepository(BukuDao)
        allBuku = repository.allbuku
    }
    suspend fun insert(data: data){
        repository.insert(data)
    }
    fun getData(): LiveData<List<data>>{
        return allBuku
    }

}