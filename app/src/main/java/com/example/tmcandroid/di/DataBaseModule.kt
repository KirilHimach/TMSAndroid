package com.example.tmcandroid.di

import android.content.Context
import androidx.room.Room
import org.koin.dsl.module

val dataBaseModule = module {
    single { provideDataBase(get()) }
    single { provideDao(get()) }
    single { provideEntity() }
}

fun provideDataBase(context: Context): com.example.tmcandroid.data.local.PostsDatabase =
    Room.databaseBuilder(
        context.applicationContext, com.example.tmcandroid.data.local.PostsDatabase::class.java,
        "posts_db"
    )
        .fallbackToDestructiveMigration()
        .build()

fun provideDao(db: com.example.tmcandroid.data.local.PostsDatabase) = db.postsDao()

fun provideEntity() = com.example.tmcandroid.data.local.Post()


