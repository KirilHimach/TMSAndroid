package com.example.tmcandroid.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Post::class], version = 1)
abstract class PostsDatabase : RoomDatabase() {

    abstract fun postsDao(): PostsDao
}