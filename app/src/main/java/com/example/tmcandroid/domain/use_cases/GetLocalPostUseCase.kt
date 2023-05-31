package com.example.tmcandroid.domain.use_cases


import com.example.tmcandroid.data.local.toPostNews
import com.example.tmcandroid.domain.models.PostNews
import com.example.tmcandroid.domain.repositories.PostRepository
import org.koin.dsl.module

val getLocalPostUseCaseModule = module {
    single { GetLocalPostUseCase(get()) }
}
class GetLocalPostUseCase(
    private val postRepository: PostRepository
) {

    suspend fun getPostInfoById(): PostNews? =
        postRepository.getLocalRepositoryById()?.toPostNews()

}