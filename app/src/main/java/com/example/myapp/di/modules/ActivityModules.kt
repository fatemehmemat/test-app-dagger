package com.example.myapp.di.modules

import com.example.myapp.di.FragmentScope
import com.example.myapp.ui.fragments.person.PersonFragment
import com.example.myapp.ui.fragments.home.HomeFragment
import com.example.myapp.ui.fragments.setting.SettingsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal interface ActivityModule

@Module
internal interface FragmentBuilder {
    @ContributesAndroidInjector(modules = [FragmentModule::class, ChildFragmentBuilder::class])
    @FragmentScope
    fun personFragment(): PersonFragment

    @ContributesAndroidInjector(modules = [FragmentModule::class, ChildFragmentBuilder::class])
    @FragmentScope
    fun homeFragment(): HomeFragment

    @ContributesAndroidInjector(modules = [FragmentModule::class, ChildFragmentBuilder::class])
    @FragmentScope
    fun settingFragment(): SettingsFragment
}