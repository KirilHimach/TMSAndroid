package com.example.tmcandroid.domain.use_cases

import com.example.tmcandroid.data.remote.dto.toPostNews
import com.example.tmcandroid.domain.models.PostNews
import com.example.tmcandroid.domain.repository.PostRepositoryDomain
import javax.inject.Inject
import javax.inject.Singleton

//Step 3. We injected the constructor for
// connect with PostRepository interface.
@Singleton
class GetPostsNewsUseCase @Inject constructor(
    private val postRepositoryDomain: PostRepositoryDomain
) {
    suspend fun getPostsNews(): List<PostNews> =
       postRepositoryDomain.getPostsNews().map { postDto ->
           postDto.toPostNews()
       }
}