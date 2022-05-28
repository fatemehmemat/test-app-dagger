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
    @ContributesAndroidInjector(modules = [PersonFragmentModule::class, PersonChildFragmentBuilder::class])
    @FragmentScope
    fun personFragment(): PersonFragment

    @ContributesAndroidInjector(modules = [HomeFragmentModule::class, HomeChildFragmentBuilder::class])
    @FragmentScope
    fun homeFragment(): HomeFragment

    @ContributesAndroidInjector(modules = [SettingsFragmentModule::class, SettingsChildFragmentBuilder::class])
    @FragmentScope
    fun settingFragment(): SettingsFragment
}