package com.example.tmcandroid.domain.use_cases

import com.example.tmcandroid.data.remote.dto.toPostNewsList
import com.example.tmcandroid.data.repositories.PostsRepositoryImpl

//Step 7. This is one of the way of getting model from "data".
class GetPostsNewsUseCase {
    fun getPostsNews() =
        PostsRepositoryImpl().getPostsNews().toPostNewsList()
}