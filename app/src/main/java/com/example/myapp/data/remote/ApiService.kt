package com.example.myapp.data.remote

import com.example.myapp.data.model.Users
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    suspend fun getUserList(): Response<List<Users>>

}
