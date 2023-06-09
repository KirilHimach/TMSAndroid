package com.example.tmcandroid.data.repositories.remote

import com.example.tmcandroid.data.remote.api.PostsApi
import com.example.tmcandroid.data.remote.dto.ResponseDto
import org.koin.dsl.module


val remoteRepositoryModule = module {
    single<PostsRemote> { PostsRemoteImpl(get()) }
}
class PostsRemoteImpl(
    private val postsApi: PostsApi
) : PostsRemote {
    override suspend fun getPosts(): ResponseDto =
         postsApi.getNews()
}