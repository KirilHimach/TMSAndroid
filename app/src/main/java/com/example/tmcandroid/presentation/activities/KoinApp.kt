package com.example.tmcandroid.presentation.activities

import android.app.Application
import com.example.tmcandroid.data.repositories.local.localRepositoryModule
import com.example.tmcandroid.data.repositories.postRepositoryImplModule
import com.example.tmcandroid.data.repositories.remote.remoteRepositoryModule
import com.example.tmcandroid.di.apiModule
import com.example.tmcandroid.di.dataBaseModule
import com.example.tmsandroid.domain.use_cases.getLocalPostUseCaseModule
import com.example.tmsandroid.domain.use_cases.getRemotePostsUseCaseModule
import com.example.tmcandroid.presentation.view_models.postsNewsViewModelModule
import com.example.tmcandroid.presentation.view_models.postInfoViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class KoinApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@KoinApp)
            modules(
                apiModule,
                dataBaseModule,
                com.example.tmcandroid.data.repositories.remote.remoteRepositoryModule,
                com.example.tmcandroid.data.repositories.local.localRepositoryModule,
                getRemotePostsUseCaseModule,
                postsNewsViewModelModule,
                getLocalPostUseCaseModule,
                postInfoViewModelModule,
                com.example.tmcandroid.data.repositories.postRepositoryImplModule
            )
        }
    }
}