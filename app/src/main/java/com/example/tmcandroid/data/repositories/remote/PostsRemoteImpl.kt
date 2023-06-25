package com.example.tmcandroid.data.repositories.remote

import com.example.tmcandroid.data.remote.api.PostsApi
import com.example.tmcandroid.data.remote.dto.ResponseDto
import javax.inject.Inject

class PostsRemoteImpl @Inject constructor(
    private val postsApi: PostsApi
) : PostsRemote {
    override suspend fun getPosts(): ResponseDto =
         postsApi.getNews()
}