package com.example.tmcandroid.data

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Response

class StartModel: ViewModel() {
    var factory = FakeUserFactory()
    val users: MutableLiveData<Response<FakeUserResponse>> = MutableLiveData()

    fun getUsersFactory() {
        viewModelScope.launch {
            users.value = factory.getFakeUserResponse()
        }
    }
}