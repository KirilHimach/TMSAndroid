package com.example.tmcandroid.data.repositories

import com.example.tmcandroid.data.remote.dto.PostDto

interface PostsRepository {
    fun getPostsNews() : List<PostDto>
}