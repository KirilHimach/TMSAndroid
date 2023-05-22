package com.example.tmcandroid.domain.models

//Step 5. Create the response model from "data".
data class PostInfo(
    val author: String? = "",
    val title: String? = "",
    val description: String? = "",
    val url: String? = "",
    val urlToImage: String? = "",
    val publishedAt: String? = "",
    val content: String? = ""
)




