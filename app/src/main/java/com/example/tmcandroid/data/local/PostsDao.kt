package com.example.tmcandroid.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PostsDao {

    @Query("SELECT * FROM post")
    suspend fun getAll() : List<Post>?

    @Query("SELECT * FROM post WHERE id = :id")
    suspend fun getById(id: Long) : Post?

    @Insert
    suspend fun insert(post: Post?)

    @Insert
    suspend fun update(post: Post?)

    @Insert
    suspend fun delete(post: Post?)
}