package com.example.tmcandroid.di.modules.repositories

import com.example.tmcandroid.data.repositories.PostRepositoryImpl
import com.example.tmcandroid.data.repositories.local.PostsLocal
import com.example.tmcandroid.data.repositories.remote.PostsRemote
import com.example.tmcandroid.domain.repositories.PostRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun providePostRepository(
        postsRemote: PostsRemote, postsLocal: PostsLocal
    ): PostRepository =
        PostRepositoryImpl(
            postsRemote = postsRemote,
            postsLocal = postsLocal
        )
}