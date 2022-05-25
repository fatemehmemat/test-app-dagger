package com.example.myapp.data.dataStore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.example.myapp.di.ApplicationContext
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DataStoreManager @Inject constructor(context: Context) {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(ConstDataStore.DATA_STORE_KEY)
    private val dataStore: DataStore<Preferences> = context.dataStore


    suspend fun setToken(token: String) {
        dataStore.edit { dataStore ->
            dataStore[ConstDataStore.TOKEN_KEY] = token
        }
    }

    fun getToken(): kotlinx.coroutines.flow.Flow<String> {
        val token: kotlinx.coroutines.flow.Flow<String> = dataStore.data
            .map {
                val token = it[ConstDataStore.TOKEN_KEY] ?: ""
                token
            }

        return token
    }

    suspend fun clearDataStore() {
        dataStore.edit {
            it.clear()
        }
    }

}