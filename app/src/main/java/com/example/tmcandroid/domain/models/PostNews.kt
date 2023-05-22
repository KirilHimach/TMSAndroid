package com.example.tmcandroid.domain.models

//Step 5. Create the response model from "data".
data class PostNews(
    val author: String? = "",
    val title: String? = "",
    val description: String? = "",
    val urlToImage: String? = "",
    val publishedAt: String? = ""
)


