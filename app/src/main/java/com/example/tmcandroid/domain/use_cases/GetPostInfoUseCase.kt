package com.example.tmcandroid.domain.use_cases

import com.example.tmcandroid.data.remote.dto.toPostInfo
import com.example.tmcandroid.domain.repository.PostRepositoryDomain
import javax.inject.Inject
import javax.inject.Singleton

//Step 3.
@Singleton
class GetPostInfoUseCase @Inject constructor(
    private val postRepositoryDomain: PostRepositoryDomain
) {
//    suspend fun getPostsInfo() =
//        postRepositoryDomain.getPostInfo().toPostInfo()
}