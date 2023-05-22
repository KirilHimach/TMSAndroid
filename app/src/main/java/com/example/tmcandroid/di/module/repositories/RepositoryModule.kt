package com.example.tmcandroid.di.module.repositories

import com.example.tmcandroid.data.repositories.PostsRepositoryImpl
import com.example.tmcandroid.data.repositories.remote.PostsRemote
import com.example.tmcandroid.domain.repository.PostRepositoryDomain
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// Step 4.
@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun providePostsRepository(postsRemote: PostsRemote): PostRepositoryDomain =
        PostsRepositoryImpl(postsRemote = postsRemote)
}