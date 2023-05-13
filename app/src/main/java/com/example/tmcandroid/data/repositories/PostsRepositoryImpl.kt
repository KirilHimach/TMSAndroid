package com.example.tmcandroid.data.repositories

import com.example.tmcandroid.data.remote.dto.PostDto
import com.example.tmcandroid.data.repositories.remote.PostsRemoteImpl
import com.example.tmcandroid.domain.repository.PostRepository

//Step 4. We must use the remote or local repository hear.
class PostsRepositoryImpl : PostRepository {
    override fun getPostsNews(): List<PostDto> =
        PostsRemoteImpl().getPosts()

    override fun getPostInfo(): PostDto =
        PostsRemoteImpl().getPostInfo()
}