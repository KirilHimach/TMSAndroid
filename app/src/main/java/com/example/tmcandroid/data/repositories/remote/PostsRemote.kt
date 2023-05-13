package com.example.tmcandroid.data.repositories.remote

import com.example.tmcandroid.data.remote.dto.PostDto

//Step 3. Create interface for connecting with PostsRepository.
interface PostsRemote {
    fun getPosts() : List<PostDto>

    fun getPostInfo() : PostDto
}