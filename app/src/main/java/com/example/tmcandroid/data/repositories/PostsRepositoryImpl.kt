package com.example.tmcandroid.data.repositories

import com.example.tmcandroid.data.remote.dto.PostDto
import com.example.tmcandroid.data.repositories.remote.PostsRemote
import com.example.tmcandroid.domain.repository.PostRepositoryDomain
import javax.inject.Inject
import javax.inject.Singleton

//Step 3. We injected the constructor for
// connect with PostsRepository interface.

@Singleton
class PostsRepositoryImpl @Inject constructor(
    private val postsRemote: PostsRemote
) : PostRepositoryDomain {

    override fun getPostsNews(): List<PostDto> =
        postsRemote.getPosts()

    override fun getPostInfo(): PostDto =
        postsRemote.getPostInfo()

}