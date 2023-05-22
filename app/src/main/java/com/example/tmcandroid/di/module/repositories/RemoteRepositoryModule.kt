package com.example.tmcandroid.di.module.repositories

import com.example.tmcandroid.data.remote.api.PostsApi
import com.example.tmcandroid.data.repositories.remote.PostsRemote
import com.example.tmcandroid.data.repositories.remote.PostsRemoteImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// Step 4.
@Module
@InstallIn(SingletonComponent::class)
class RemoteRepositoryModule {

    @Singleton
    @Provides
    fun providePostsRemote(postsApi: PostsApi): PostsRemote =
        PostsRemoteImpl(postsApi = postsApi)
}