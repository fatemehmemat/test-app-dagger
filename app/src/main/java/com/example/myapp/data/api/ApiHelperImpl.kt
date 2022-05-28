package com.example.myapp.data.api

import com.example.myapp.data.model.Users
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {

    override fun getUsers(): Flow<Response<List<Users>>> = flow {
        emit(apiService.getUserList())
    }.flowOn(Dispatchers.IO)
}