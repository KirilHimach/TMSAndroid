package com.example.tmcandroid.data.repositories.remote

import com.example.tmcandroid.data.remote.dto.ResponseDto

interface PostsRemote {
    suspend fun getPosts() : ResponseDto
}