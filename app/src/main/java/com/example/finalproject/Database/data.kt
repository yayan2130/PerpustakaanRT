package com.example.finalproject.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="data")
data class data(
        @PrimaryKey
        @ColumnInfo(name = "id")
        val id: Int,

        @ColumnInfo(name = "gambarBuku")
        val gambarBuku: Int,

        @ColumnInfo(name = "namaBuku")
        val namaBuku: String,

        @ColumnInfo(name = "sinopsisBuku")
        val sinopsisBuku: String


)