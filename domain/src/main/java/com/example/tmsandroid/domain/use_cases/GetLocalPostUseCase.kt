package com.example.tmsandroid.domain.use_cases


import com.example.tmsandroid.domain.models.PostNews
import com.example.tmsandroid.domain.repositories.PostRepository
import org.koin.dsl.module

val getLocalPostUseCaseModule = module {
    single { GetLocalPostUseCase(get()) }
}
class GetLocalPostUseCase(
    private val postRepository: PostRepository
) {

    suspend fun getPostInfoById(): PostNews? =
        postRepository.getLocalRepositoryById() //?.toPostNews()

}