package com.example.tmcandroid.presentation.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tmcandroid.domain.models.PostNewsList
import com.example.tmcandroid.domain.use_cases.GetPostsNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

//Step 4.
@HiltViewModel
class PostsNewsViewModel @Inject constructor(
    private val getPostsNewsUseCase: GetPostsNewsUseCase
) : ViewModel() {

    private val _postNewsList = MutableLiveData<PostNewsList>()
    val postNewsList: LiveData<PostNewsList> = _postNewsList

    init {
        getPostNews()
    }

    private fun getPostNews() {
        _postNewsList.value = getPostsNewsUseCase.getPostsNews()
    }
}