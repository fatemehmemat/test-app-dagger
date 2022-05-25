package com.example.myapp.data.remote

import com.example.myapp.data.model.Users
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {

    override suspend fun getUserList(): Response<List<Users>> {
        return apiService.getUserList()
    }

    override suspend fun getUsers(): Flow<Response<List<Users>>> {
        return flow { emit(apiService.getUserList()) }.flowOn(Dispatchers.IO)
    }

}