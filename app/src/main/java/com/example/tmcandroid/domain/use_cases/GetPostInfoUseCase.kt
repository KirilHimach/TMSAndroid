package com.example.tmcandroid.domain.use_cases

import com.example.tmcandroid.data.remote.dto.toPostInfo
import com.example.tmcandroid.data.repositories.PostsRepositoryImpl

//Step 7. This is one of the way of getting model from "data".
class GetPostInfoUseCase {
    fun getPostsInfo() =
        PostsRepositoryImpl().getPostInfo().toPostInfo()
}