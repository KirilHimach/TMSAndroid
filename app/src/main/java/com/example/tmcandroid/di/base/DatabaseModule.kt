package com.example.tmcandroid.di.base

import android.app.Application
import androidx.room.Room
import com.example.tmcandroid.data.local.Post
import com.example.tmcandroid.data.local.PostsDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDataBase(context: Application): PostsDatabase =
        Room.databaseBuilder(
            context,
            PostsDatabase::class.java,
            "posts_db"
        )
            .fallbackToDestructiveMigration()
            .build()

    @Singleton
    @Provides
    fun provideDao(db: PostsDatabase) = db.postsDao()

    @Provides
    fun provideEntity() = Post()
}