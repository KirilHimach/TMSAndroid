package com.example.tmcandroid.di.module

import com.example.tmcandroid.domain.repository.PostRepositoryDomain
import com.example.tmcandroid.domain.use_cases.GetPostInfoUseCase
import com.example.tmcandroid.domain.use_cases.GetPostsNewsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

// Step 4.
@Module
@InstallIn(SingletonComponent::class)
class UseCasesModule {

    @Provides
    fun provideGetPostInfoUseCase(postRepositoryDomain: PostRepositoryDomain) =
        GetPostInfoUseCase(postRepositoryDomain = postRepositoryDomain)


    @Provides
    fun provideGetPostsNewsUseCase(postRepositoryDomain: PostRepositoryDomain) =
        GetPostsNewsUseCase(postRepositoryDomain = postRepositoryDomain)
}