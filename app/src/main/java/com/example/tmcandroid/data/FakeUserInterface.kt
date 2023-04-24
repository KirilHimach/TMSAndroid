package com.example.tmcandroid.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FakeUserInterface {
    @GET("/api")
    suspend fun fakeUserResponse(@Query("results") count: Int) : Response<FakeUserResponse>
}