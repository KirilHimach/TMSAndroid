package com.example.tmcandroid.presentation.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import com.example.tmcandroid.databinding.FragmentTestBinding
import com.example.tmcandroid.presentation.view_models.TestViewModel
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class TestFragment : Fragment() {
    private lateinit var binding: FragmentTestBinding
    private val testViewModel: TestViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentTestBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        onCoroutinesRun()
    }

    private fun onCoroutinesRun() {
        onStartTenCoroutines()
    }

    private fun onStartTenCoroutines() {
        testViewModel.viewModelScope.launch {
            Log.d("TEST_ANDROID", "!!!!! Start coroutines TestFragment !!!!!")
            onStartFiveLaunch()
            onStartFiveAsync()
            Log.d("TEST_ANDROID", "!!!Finish coroutines TestFragment !!!")
        }
    }

    private suspend fun onStartFiveLaunch() = withContext(IO) {
        coroutineScope {
            launch { downloadOne() }
            launch { downloadTwo() }
            launch { downloadThree() }
            launch { downloadFour() }
            launch { downloadFive() }
        }
    }

    private suspend fun onStartFiveAsync() = withContext(IO) {
        coroutineScope {
            async { downloadSix() }
            async { downloadSeven() }
            async { downloadEight() }
            async { downloadNine() }
            async { downloadTen() }
        }
    }

    private suspend fun downloadOne() = withContext(IO) {
        Log.d("TEST_ANDROID", "Downloading ONE.....")
        delay(3000)
        Log.d("TEST_ANDROID", "The ONE is downloaded!!!!!!!!")
    }

    private suspend fun downloadTwo() = withContext(IO) {
        Log.d("TEST_ANDROID", "Downloading TWO.....")
       // delay(3000)
        Log.d("TEST_ANDROID", "The TWO is downloaded!!!!!!!!")
    }

    private suspend fun downloadThree() = withContext(IO) {
        Log.d("TEST_ANDROID", "Downloading THREE.....")
        delay(2000)
        Log.d("TEST_ANDROID", "The THREE is downloaded!!!!!!!!")
    }

    private suspend fun downloadFour() = withContext(IO) {
        Log.d("TEST_ANDROID", "Downloading FOUR.....")
        delay(3000)
        Log.d("TEST_ANDROID", "The FOUR is downloaded!!!!!!!!")
    }

    private suspend fun downloadFive() = withContext(IO) {
        Log.d("TEST_ANDROID", "Downloading FIVE.....")
        delay(3000)
        Log.d("TEST_ANDROID", "The FIVE is downloaded!!!!!!!!")
    }

    private suspend fun downloadSix() = withContext(IO) {
        Log.d("TEST_ANDROID", "Downloading SIX.....")
        delay(3000)
        Log.d("TEST_ANDROID", "The SIX is downloaded!!!!!!!!")
    }

    private suspend fun downloadSeven() = withContext(IO) {
        Log.d("TEST_ANDROID", "Downloading SEVEN.....")
        delay(1000)
        Log.d("TEST_ANDROID", "The SEVEN is downloaded!!!!!!!!")
    }

    private suspend fun downloadEight() = withContext(IO) {
        Log.d("TEST_ANDROID", "Downloading EIGHT.....")
        delay(3000)
        Log.d("TEST_ANDROID", "The EIGHT is downloaded!!!!!!!!")
    }

    private suspend fun downloadNine() = withContext(IO) {
        Log.d("TEST_ANDROID", "Downloading NINE.....")
        delay(2000)
        Log.d("TEST_ANDROID", "The NINE is downloaded!!!!!!!!")
    }

    private suspend fun downloadTen() = withContext(IO) {
        Log.d("TEST_ANDROID", "Downloading TEN.....")
        //delay(3000)
        Log.d("TEST_ANDROID", "The TEN is downloaded!!!!!!!!")
    }
}