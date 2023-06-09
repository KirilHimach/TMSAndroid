package com.example.tmcandroid.data.repositories.local

import com.example.tmcandroid.data.local.Post
import com.example.tmcandroid.data.local.PostsDao
import org.koin.dsl.module

val localRepositoryModule = module {
    single<PostsLocal> { PostsLocalImpl(get()) }
}

class PostsLocalImpl(
    private val postsDao: PostsDao
) : PostsLocal {

    override suspend fun getById(id: Long): Post? =
        postsDao.getById(id)


    override suspend fun getLocalPosts(): List<Post>? =
        postsDao.getAll()

    override suspend fun insertPost(post: Post) =
        postsDao.insert(post)

    override suspend fun deletePost(post: Post) =
        postsDao.delete(post)

    override suspend fun updatePost(post: Post) =
        postsDao.update(post)
}