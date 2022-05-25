package com.example.myapp.data.model

import androidx.annotation.NonNull
import androidx.room.PrimaryKey

data class Users(
    @PrimaryKey
    @NonNull
    val id: Int,
    val title: String,
    val userId: Int,
    val body: String
)