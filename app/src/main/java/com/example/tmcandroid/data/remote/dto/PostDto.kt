package com.example.tmcandroid.data.remote.dto

import com.example.tmcandroid.domain.models.PostInfo
import com.example.tmcandroid.domain.models.PostNews
import com.example.tmcandroid.domain.models.PostNewsList

data class PostDto(
    val name: String?,
    val location: String?,
    val email: String?,
    val dob: String?,
    val phone: String?,
    val picture: String?
)

fun PostDto.toPostNews() =
    PostNews(
        name = name,
        location = location,
        dob = dob,
        picture = picture
    )


fun PostDto.toPostInfo() =
    PostInfo(
        name = name,
        location = location,
        email = email,
        dob = dob,
        phone = phone,
        picture = picture
    )


fun List<PostDto>.toPostNewsList() =
    PostNewsList(
        this.map {
            it.toPostNews()
        }
    )