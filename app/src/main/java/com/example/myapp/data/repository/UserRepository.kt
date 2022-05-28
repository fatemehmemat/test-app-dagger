package com.example.myapp.data.repository

import com.example.myapp.data.model.Users
import com.example.myapp.data.api.ApiHelper
import com.example.myapp.data.room.dao.UserDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import javax.inject.Inject

class UserRepository @Inject constructor(private val apiHelper: ApiHelper,private val userDao: UserDao) {
    fun getUserListFromServerFlow(): Flow<Response<List<Users>>> = apiHelper.getUsers()

    suspend fun addUsersIntoLocalDb(users: List<Users>) {
        userDao.addUser(users)
    }

    suspend fun getUserListFromLocalDbFlow(): Flow<List<Users>> = flow {
            emit(userDao.getUsers())
        }.flowOn(Dispatchers.IO) // Use the IO thread for this Flow

}