package com.example.tmcandroid.di.modules

import com.example.tmcandroid.domain.repositories.PostRepository
import com.example.tmcandroid.domain.use_cases.GetLocalPostUseCase
import com.example.tmcandroid.domain.use_cases.GetRemotePostsUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCasesModule {

    @Provides
    fun provideLocalPostUseCase(postRepository: PostRepository) =
        GetLocalPostUseCase(postRepository)

    @Provides
    fun provideRemotePostsUseCase(postRepository: PostRepository) =
        GetRemotePostsUseCase(postRepository)
}