package com.example.tmcandroid.data.repositories.remote

import com.example.tmcandroid.data.remote.dto.PostDto

interface PostsRemote {
    fun getPosts() : List<PostDto>

    fun getPostInfo() : PostDto
}