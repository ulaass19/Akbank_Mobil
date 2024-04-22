package com.example.akbankmobil.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val nameSurname: String,
    val turkishIdentityNo: String,
    val password:String
)