package com.example.myapp.di.modules

import com.example.myapp.di.FragmentScope
import com.example.myapp.ui.fragments.HomeFragment
import com.example.myapp.ui.fragments.PersonFragment
import com.example.myapp.ui.fragments.SettingsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal class MainActivityModule

@Module
internal interface MainFragmentBuilder {
    @ContributesAndroidInjector(modules = [PersonFragmentModule::class])
    @FragmentScope
    fun personFragment(): PersonFragment

    @ContributesAndroidInjector(modules = [HomeFragmentModule::class])
    @FragmentScope
    fun homeFragment(): HomeFragment

    @ContributesAndroidInjector(modules = [SettingsFragmentModule::class])
    @FragmentScope
    fun settingFragment(): SettingsFragment

}
