package com.example.tmcandroid.di

import android.content.Context
import androidx.room.Room
import com.example.tmcandroid.data.local.Post
import com.example.tmcandroid.data.local.PostsDatabase
import org.koin.dsl.module

val dataBaseModule = module {
    single { provideDataBase(get()) }
    single { provideDao(get()) }
    single { provideEntity() }
}

fun provideDataBase(context: Context): PostsDatabase =
    Room.databaseBuilder(
        context.applicationContext, PostsDatabase::class.java,
        "posts_db"
    )
        .fallbackToDestructiveMigration()
        .build()

fun provideDao(db: PostsDatabase) = db.postsDao()

fun provideEntity() = Post()


