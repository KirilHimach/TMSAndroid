package com.example.tmcandroid.data.remote.dto

import com.google.gson.annotations.SerializedName

data class ResponseDto(
    @SerializedName("totalResults")
    val totalResults: Int?,
    @SerializedName("articles")
    val articles: List<PostDto>?
)