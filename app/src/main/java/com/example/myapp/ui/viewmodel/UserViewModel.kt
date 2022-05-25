package com.example.myapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.myapp.data.model.Users
import com.example.myapp.data.remote.UserRepository
import com.example.myapp.utils.NetworkHelper
import com.example.myapp.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class UserViewModel @Inject constructor(
    private val networkHelper: NetworkHelper,
    private val userRepository: UserRepository
) : ViewModel() {

    private  val TAG = "UserViewModel"
    private var userListLiveData: LiveData<Resource<List<Users>>>? = null

    fun getUsers(): LiveData<Resource<List<Users>>>? {
        userListLiveData = liveData(Dispatchers.IO) {
            if (networkHelper.isNetworkConnected()) {
                userRepository.getUserListFromServerFlow()
                    .catch { exception -> emit(Resource.error(exception.cause.toString(), null)) }
                    .collect {
                        if (it.isSuccessful) {
                            emit(Resource.success(it.body()))
                            Log.d(TAG, "getUsers: "+it.body())

                        }
                    }
            }
        }
        return userListLiveData
    }


}