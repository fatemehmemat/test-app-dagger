package com.example.myapp.data.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapp.data.model.Users


@Dao
interface UserDao {
    @Query("SELECT * FROM tblUsers")
    suspend  fun getUsers(): List<Users>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUser(users: List<Users>)
}