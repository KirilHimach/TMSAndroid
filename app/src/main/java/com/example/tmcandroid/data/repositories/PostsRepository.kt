package com.example.tmcandroid.data.repositories

import com.example.tmcandroid.data.remote.dto.PostDto

//Step 4. It`s the point of connect to "data". The "domain" must create an inquire of this interface.
interface PostsRepository {
    fun getPosts() : List<PostDto>
}