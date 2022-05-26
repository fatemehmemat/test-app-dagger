package com.example.myapp.data.remote

import com.example.myapp.data.model.Users
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface ApiHelper {

    fun getUsers(): Flow<Response<List<Users>>>
}