package com.example.sesshokuapplication.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "history")
data class Contact(
    @PrimaryKey @ColumnInfo(name = "date") val date:String,
    @PrimaryKey @ColumnInfo(name = "time") val time:String,
    @PrimaryKey @ColumnInfo(name = "name") val name:String
)