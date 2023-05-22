package com.example.tmcandroid.presentation.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tmcandroid.domain.models.PostInfo
import com.example.tmcandroid.domain.use_cases.GetPostInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

//Step 4.
@HiltViewModel
class PostInfoViewModel @Inject constructor(
    private val getPostInfoUseCase: GetPostInfoUseCase
) : ViewModel() {
    private val _postInfo = MutableLiveData<PostInfo>()
    val postInfo: LiveData<PostInfo> = _postInfo

    init {
        viewModelScope.launch {
            getPostInfo()
        }
    }

    private suspend fun getPostInfo() {
        //_postInfo.value = getPostInfoUseCase.getPostsInfo()
    }
}