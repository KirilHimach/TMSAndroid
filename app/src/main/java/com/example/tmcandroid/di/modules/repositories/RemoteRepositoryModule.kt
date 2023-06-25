package com.example.tmcandroid.di.modules.repositories

import com.example.tmcandroid.data.remote.api.PostsApi
import com.example.tmcandroid.data.repositories.remote.PostsRemote
import com.example.tmcandroid.data.repositories.remote.PostsRemoteImpl
import dagger.Module
import dagger.Provides

@Module
class RemoteRepositoryModule {

    @Provides
    fun providePostsRemote(postsApi: PostsApi): PostsRemote =
        PostsRemoteImpl(postsApi)
}