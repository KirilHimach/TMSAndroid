package com.example.tmsandroid.domain.use_cases

import com.example.tmsandroid.domain.models.PostNews
import com.example.tmsandroid.domain.repositories.PostRepository
import org.koin.dsl.module

val getRemotePostsUseCaseModule = module {
    single { GetRemotePostsUseCase(get()) }
}

class GetRemotePostsUseCase(
    private val postRepository: PostRepository
) {
    suspend fun getPostsNews(): List<PostNews> =
//        postRepository.getRemoteRepository().map { postDto ->
//            postDto.toPostNews()
//        }
        postRepository.getRemoteRepository()
}