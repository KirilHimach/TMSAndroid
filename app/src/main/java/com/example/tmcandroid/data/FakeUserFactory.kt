package com.example.tmcandroid.data

import retrofit2.Response

class FakeUserFactory {

    suspend fun getFakeUserResponse(): Response<FakeUserResponse>{
        return RetrofitInstance.api.fakeUserResponse(50)
    }
}

