package com.example.tmsandroid.domain.repositories

import com.example.tmsandroid.domain.models.PostNews


interface PostRepository {

    suspend fun getRemoteRepository() : List<PostNews>

    suspend fun getLocalRepositoryById() : PostNews?
}