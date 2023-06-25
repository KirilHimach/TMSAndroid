package com.example.tmcandroid.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tmcandroid.presentation.view_models.PostInfoViewModel
import com.example.tmcandroid.presentation.view_models.PostsNewsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(PostInfoViewModel::class)
    fun postInfoViewModel(viewModel: PostInfoViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PostsNewsViewModel::class)
    fun postNewsViewModel(viewModel: PostsNewsViewModel): ViewModel
}