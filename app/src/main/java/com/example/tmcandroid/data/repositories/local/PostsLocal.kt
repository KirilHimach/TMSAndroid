package com.example.tmcandroid.data.repositories.local

import com.example.tmcandroid.data.local.Post

interface PostsLocal {

    suspend fun getLocalPosts(): List<Post>?

    suspend fun getById(id: Long) : Post?

    suspend fun insertPost(post: Post)

    suspend fun deletePost(post: Post)

    suspend fun updatePost(post: Post)
}