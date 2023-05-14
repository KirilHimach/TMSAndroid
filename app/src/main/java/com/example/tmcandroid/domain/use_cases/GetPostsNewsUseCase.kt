package com.example.tmcandroid.domain.use_cases

import android.util.Log
import com.example.tmcandroid.data.remote.dto.toPostNewsList
import com.example.tmcandroid.data.repositories.PostsRepositoryImpl
import com.example.tmcandroid.domain.repository.PostRepositoryDomain
import javax.inject.Inject
import javax.inject.Singleton

//Step 3. We injected the constructor for
// connect with PostRepository interface.
@Singleton
class GetPostsNewsUseCase @Inject constructor(
    private val postRepositoryDomain: PostRepositoryDomain
) {
    fun getPostsNews() =
       postRepositoryDomain.getPostsNews().toPostNewsList()
}