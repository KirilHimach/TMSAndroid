package com.example.tmcandroid.data.repositories

import com.example.tmcandroid.data.local.Post
import com.example.tmcandroid.data.remote.dto.PostDto
import com.example.tmcandroid.data.remote.dto.toLocalPost
import com.example.tmcandroid.data.repositories.local.PostsLocal
import com.example.tmcandroid.data.repositories.remote.PostsRemote
import com.example.tmcandroid.domain.repositories.PostRepository
import org.koin.dsl.module

val postRepositoryImplModule = module {
    single<PostRepository> { PostRepositoryImpl(get(), get()) }
}

class PostRepositoryImpl(
    private val postsLocal: PostsLocal,
    private val postsRemote: PostsRemote
) : PostRepository {

    override suspend fun getRemoteRepository(): List<PostDto> {
        val posts = postsRemote.getPosts().articles.orEmpty()
        if (posts.isNotEmpty()) {
            posts.forEach { post ->
                postsLocal.insertPost(post.toLocalPost())
            }
        }
        return posts
    }

    override suspend fun getLocalRepositoryById(): Post? =
         postsLocal.getById(3)
    //TODO
}