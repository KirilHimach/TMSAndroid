package com.example.tmcandroid.presentation.view_models

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tmcandroid.domain.models.PostNews
import com.example.tmcandroid.domain.use_cases.GetPostsNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

//Step 4.
@HiltViewModel
class PostsNewsViewModel @Inject constructor(
    private val getPostsNewsUseCase: GetPostsNewsUseCase
) : ViewModel() {

    private val _postNewsList = MutableLiveData<List<PostNews>>()
    val postNewsList: LiveData<List<PostNews>> = _postNewsList

    init {
        viewModelScope.launch {
            getPostNews()
        }
    }

    private suspend fun getPostNews() {
        _postNewsList.value = getPostsNewsUseCase.getPostsNews()
    }
}