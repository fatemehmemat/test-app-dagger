package com.example.myapp.data.repository

import com.example.myapp.data.model.Users
import com.example.myapp.data.remote.ApiHelper
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject

class UserRepository @Inject constructor(private val apiHelper: ApiHelper) {
    fun getUserListFromServerFlow(): Flow<Response<List<Users>>> = apiHelper.getUsers()
}