package com.example.myapp.di.modules

import android.content.Context
import com.example.myapp.data.dataStore.DataStoreManager
import com.example.myapp.di.ApplicationContext
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {
    @Provides
    @Singleton
    fun dataStoreManager(@ApplicationContext appContext: Context): DataStoreManager = DataStoreManager(appContext)
}
