package com.example.tmcandroid.domain.models

//Step 5. Create the response model from "data".
data class PostNewsList(
    val posts: List<PostNews> = emptyList()
    )