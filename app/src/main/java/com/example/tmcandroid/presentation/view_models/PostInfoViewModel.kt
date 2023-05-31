package com.example.tmcandroid.presentation.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tmcandroid.domain.models.PostNews
import com.example.tmcandroid.domain.use_cases.GetLocalPostUseCase
import kotlinx.coroutines.launch
import org.koin.dsl.module


val postInfoViewModelModule = module {
    single { PostInfoViewModel(get()) }
}
open class PostInfoViewModel(
    private val getLocalPostUseCase: GetLocalPostUseCase
) : ViewModel() {
    private val _postInfo = MutableLiveData<PostNews>()
    val postInfo: LiveData<PostNews> = _postInfo

    init {
        viewModelScope.launch {
            getPostInfo()
        }
    }

    private suspend fun getPostInfo() {
        _postInfo.value = getLocalPostUseCase.getPostInfoById()
    }
}