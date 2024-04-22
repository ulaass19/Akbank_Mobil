package com.example.akbankmobil.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.akbankmobil.entity.User

@Dao
interface UserDao {
    @Query("SELECT * FROM users")
    suspend fun getAllUsers():List<User>

    @Insert
    suspend fun insertUser(user: User)

    @Query("SELECT COUNT(*) FROM users WHERE turkishIdentityNo = :tcNo AND password = :password")
    suspend fun getUserCount(tcNo: String, password: String): Int

}