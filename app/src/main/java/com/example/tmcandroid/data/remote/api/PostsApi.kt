package com.example.tmcandroid.data.remote.api

import com.example.tmcandroid.data.remote.dto.ResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface PostsApi {
    companion object {
        const val API_KEY = "bfc954d61318474f817786faab8df127"
        const val GET_POSTS_REQUEST = "top-headlines"
        const val KEY_PARAM = "apiKey"
        const val SOURCE_CONST = "techcrunch"
        const val SOURCE_PARAM = "sources"
    }

    @GET(GET_POSTS_REQUEST)
    suspend fun getNews(
        @Query(SOURCE_PARAM) source: String = SOURCE_CONST,
        @Query(KEY_PARAM) apiKey: String = API_KEY
    ): ResponseDto
}