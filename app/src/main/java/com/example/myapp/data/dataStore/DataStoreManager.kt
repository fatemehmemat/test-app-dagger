package com.example.myapp.data.dataStore

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.myapp.di.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

// @Singleton//?????
class DataStoreManager @Inject constructor(@ApplicationContext private val context: Context) {
    companion object ConstDataStore {
        private const val DATA_STORE_KEY = "data_store_key"
        private val TOKEN_KEY = stringPreferencesKey("token_key")
    }

    private val Context.dataStore by preferencesDataStore(DATA_STORE_KEY)

    suspend fun saveToken(token: String) = with(context) {
        dataStore.edit { it[TOKEN_KEY] = token }
    }

    fun getToken(): Flow<String> = context.dataStore.data.map {
        it[TOKEN_KEY] ?: ""
    }

    suspend fun clearToken() = with(context) {
        dataStore.edit { it.clear() }
    }
}