package com.example.tmcandroid.data.remote.dto

import com.example.tmcandroid.data.local.Post
import com.example.tmsandroid.domain.models.PostNews
import com.google.gson.annotations.SerializedName

data class PostDto(
    @SerializedName("author")
    val author: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("urlToImage")
    val urlToImage: String,
    @SerializedName("publishedAt")
    val publishedAt: String,
    @SerializedName("content")
    val content: String
)

fun PostDto.toPostNews() =
    PostNews(
        author = author,
        title = title,
        description = description,
        urlToImage = urlToImage,
        publishedAt = publishedAt,
    )

fun PostDto.toLocalPost() =
    Post(
        author = author,
        title = title,
        description = description,
        url = url,
        urlToImage = urlToImage,
        publishedAt = publishedAt
    )