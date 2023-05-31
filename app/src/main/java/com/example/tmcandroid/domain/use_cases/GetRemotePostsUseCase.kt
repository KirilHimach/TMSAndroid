package com.example.tmcandroid.domain.use_cases

import com.example.tmcandroid.data.remote.dto.toPostNews
import com.example.tmcandroid.domain.models.PostNews
import com.example.tmcandroid.domain.repositories.PostRepository
import org.koin.dsl.module

val getRemotePostsUseCaseModule = module {
    single { GetRemotePostsUseCase(get()) }
}

class GetRemotePostsUseCase(
    private val postRepository: PostRepository
) {
    suspend fun getPostsNews(): List<PostNews> =
        postRepository.getRemoteRepository().map { postDto ->
            postDto.toPostNews()
        }
}