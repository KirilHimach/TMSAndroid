package com.example.tmcandroid.di.modules.repositories

import com.example.tmcandroid.data.local.PostsDao
import com.example.tmcandroid.data.repositories.local.PostsLocal
import com.example.tmcandroid.data.repositories.local.PostsLocalImpl
import dagger.Module
import dagger.Provides

@Module
class LocalRepositoryModule {

    @Provides
    fun providePostsLocal(postsDao: PostsDao): PostsLocal =
        PostsLocalImpl(postsDao)
}