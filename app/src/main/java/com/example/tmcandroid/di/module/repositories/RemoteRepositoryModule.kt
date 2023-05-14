package com.example.tmcandroid.di.module.repositories

import com.example.tmcandroid.data.repositories.remote.PostsRemote
import com.example.tmcandroid.data.repositories.remote.PostsRemoteImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

// Step 4.
@Module
@InstallIn(SingletonComponent::class)
class RemoteRepositoryModule {

    @Provides
    fun providePostsRemote(): PostsRemote = PostsRemoteImpl()
}