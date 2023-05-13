package com.example.tmcandroid.presentation.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tmcandroid.domain.models.PostNewsList
import com.example.tmcandroid.domain.use_cases.GetPostsNewsUseCase

//Step 8. This is point of getting models from "domain".
open class PostsNewsViewModel : ViewModel() {

    private val _postNewsList = MutableLiveData<PostNewsList>()
    val postNewsList: LiveData<PostNewsList> = _postNewsList

    init {
        getPostNews()
    }

    private fun getPostNews() {
        _postNewsList.value = GetPostsNewsUseCase().getPostsNews()
    }
}