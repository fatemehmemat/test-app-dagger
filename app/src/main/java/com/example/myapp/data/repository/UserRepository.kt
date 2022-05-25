package com.example.myapp.data.remote

import com.example.myapp.data.model.Users
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import javax.inject.Inject

class UserRepository @Inject constructor(private val apiHelper: ApiHelper){
    suspend fun getUserListFromServerFlow(): Flow<Response<List<Users>>> {
        return flow {
            val userList=apiHelper.getUserList()
            emit(userList)
        }.flowOn(Dispatchers.IO)
    }
}