package com.example.tmcandroid.domain.repository

import com.example.tmcandroid.data.remote.dto.PostDto

//Step 6. It`s the point of connect to "domain".
interface PostRepository {
    fun getPostsNews() : List<PostDto>
    fun getPostInfo() : PostDto
}