package com.example.myapp.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapp.data.model.Users
import com.example.myapp.data.room.dao.UserDao

//exportSchema is true by default but you can disable it for databases when you don't want to keep history of versions (like an in-memory only database).
@Database(entities = [Users::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract val userDao: UserDao

}