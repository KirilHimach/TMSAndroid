package com.example.tmcandroid.di.base

import android.app.Application
import com.example.tmcandroid.di.modules.UseCasesModule
import com.example.tmcandroid.di.modules.ViewModelModule
import com.example.tmcandroid.di.modules.repositories.LocalRepositoryModule
import com.example.tmcandroid.di.modules.repositories.RemoteRepositoryModule
import com.example.tmcandroid.di.modules.repositories.RepositoryModule
import com.example.tmcandroid.presentation.fragments.InfoFragment
import com.example.tmcandroid.presentation.fragments.NewsFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApiModule::class,
        DatabaseModule::class,
        LocalRepositoryModule::class,
        RemoteRepositoryModule::class,
        RepositoryModule::class,
        UseCasesModule::class,
        ViewModelModule::class
    ]
)
internal interface DaggerComponent {

    fun inject(fragment: NewsFragment)
    fun inject(fragment: InfoFragment)

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance application: Application): DaggerComponent
    }
}