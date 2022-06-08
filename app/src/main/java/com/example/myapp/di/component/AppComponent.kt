package com.example.myapp.di.component

import android.content.Context
import com.example.myapp.CoreApp
import com.example.myapp.di.ApplicationContext
import com.example.myapp.di.modules.*
import com.example.myapp.di.modules.NetworkModule
import com.example.myapp.di.modules.RetrofitModule
import com.example.myapp.di.modules.RoomModule
import com.example.myapp.di.modules.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton
//A @Component interface gives the information Dagger needs to generate the graph at compile-time.
// The parameter of the interface methods define what classes request injection.
@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityBuilder::class,
        ViewModelModule::class,
        RetrofitModule::class,
        NetworkModule::class,
        RoomModule::class
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