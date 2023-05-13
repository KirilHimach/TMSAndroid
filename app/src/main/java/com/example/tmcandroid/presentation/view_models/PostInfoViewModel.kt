package com.example.tmcandroid.presentation.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tmcandroid.domain.models.PostInfo
import com.example.tmcandroid.domain.use_cases.GetPostInfoUseCase

//Step 8. This is point of getting models from "domain".
open class PostInfoViewModel : ViewModel() {
    private val _postInfo = MutableLiveData<PostInfo>()
    val postInfo: LiveData<PostInfo> = _postInfo

    init {
        getPostInfo()
    }

    private fun getPostInfo() {
        _postInfo.value = GetPostInfoUseCase().getPostsInfo()
    }
}