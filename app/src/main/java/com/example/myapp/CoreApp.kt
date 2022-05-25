package com.example.myapp

import android.app.Application
import com.example.myapp.di.component.DaggerAppComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class CoreApp : Application() , HasAndroidInjector{
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>
    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder()
            .applicationContext(applicationContext)
            .build().inject(this)


    }
    override fun androidInjector() = dispatchingAndroidInjector
}
