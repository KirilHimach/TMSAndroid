package com.example.tmcandroid.data

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://randomuser.me/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

    }
    val api: FakeUserInterface by lazy {
        retrofit.create(FakeUserInterface::class.java)
    }
}