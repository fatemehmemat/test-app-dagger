package com.example.myapp.data.remote

import com.example.myapp.data.model.Users
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface ApiHelper {
    suspend fun getUserList(): Response<List<Users>>

    suspend fun getUsers(): Flow<Response<List<Users>>>

}