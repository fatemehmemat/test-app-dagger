package com.example.myapp.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapp.di.ViewModelFactory
import com.example.myapp.di.ViewModelKey
import com.example.myapp.ui.viewmodel.UserViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal interface ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(UserViewModel::class)
    fun userViewModel(viewModel: UserViewModel): ViewModel

   /* @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun mainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    fun homeViewModel(viewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailViewModel::class)
    fun detailViewModel(viewModel: DetailViewModel): ViewModel
*/
    @Binds
    fun templateViewModelFactory(viewModelFactory: ViewModelFactory):
            ViewModelProvider.Factory
}
