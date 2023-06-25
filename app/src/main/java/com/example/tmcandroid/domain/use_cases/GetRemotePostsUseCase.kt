package com.example.tmcandroid.domain.use_cases

import com.example.tmcandroid.data.remote.dto.toPostNews
import com.example.tmcandroid.domain.models.PostNews
import com.example.tmcandroid.domain.repositories.PostRepository
import javax.inject.Inject


class GetRemotePostsUseCase @Inject constructor(
    private val postRepository: PostRepository
) {
    suspend fun getPostsNews(): List<PostNews> =
        postRepository.getRemoteRepository().map { postDto ->
            postDto.toPostNews()
        }
}