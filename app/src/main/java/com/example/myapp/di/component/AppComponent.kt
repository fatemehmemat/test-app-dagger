package com.example.myapp.di.component

import android.content.Context
import com.example.myapp.CoreApp
import com.example.myapp.di.ApplicationContext
import com.example.myapp.di.modules.ActivityBuilder
import com.example.myapp.di.modules.DataModule
import com.example.myapp.di.modules.RetrofitModule
import com.example.myapp.di.modules.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        DataModule::class,
        ActivityBuilder::class,
        ViewModelModule::class,
        RetrofitModule::class
    ]
)
interface AppComponent {
    fun inject(application: CoreApp)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun applicationContext(@ApplicationContext context: Context): Builder

        fun build(): AppComponent
    }
}