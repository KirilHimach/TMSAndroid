package com.example.tmcandroid.presentation.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tmcandroid.domain.models.PostNews
import com.example.tmcandroid.domain.use_cases.GetRemotePostsUseCase
import kotlinx.coroutines.launch
import org.koin.dsl.module


val postsNewsViewModelModule = module {
    single { PostsNewsViewModel(get()) }
}
open class PostsNewsViewModel(
    private val getRemotePostsUseCase: GetRemotePostsUseCase
) : ViewModel() {

    private val _postNewsList = MutableLiveData<List<PostNews>>()
    val postNewsList: LiveData<List<PostNews>> = _postNewsList

    init {
        viewModelScope.launch {
            getPostNews()
        }
    }

    private suspend fun getPostNews() {
        _postNewsList.value = getRemotePostsUseCase.getPostsNews()
    }
}