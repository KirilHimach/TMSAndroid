package com.example.tmcandroid.presentation.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tmcandroid.domain.models.PostNews
import com.example.tmcandroid.domain.use_cases.GetRemotePostsUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject


open class PostsNewsViewModel @Inject constructor(
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