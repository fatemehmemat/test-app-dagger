package com.example.myapp.di.modules

import com.example.myapp.ui.activities.MainActivity
import com.example.myapp.di.ActivityScope
import com.example.myapp.di.modules.MainActivityModule
import com.example.myapp.di.modules.MainFragmentBuilder
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityBuilder {
    @ContributesAndroidInjector(modules = [MainActivityModule::class, MainFragmentBuilder::class])
    @ActivityScope
    fun MainActivity(): MainActivity
}