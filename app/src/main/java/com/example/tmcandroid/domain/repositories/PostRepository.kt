package com.example.tmcandroid.domain.repositories

import com.example.tmcandroid.data.local.Post
import com.example.tmcandroid.data.remote.dto.PostDto

interface PostRepository {

    suspend fun getRemoteRepository() : List<PostDto>

    suspend fun getLocalRepositoryById() : Post?
}