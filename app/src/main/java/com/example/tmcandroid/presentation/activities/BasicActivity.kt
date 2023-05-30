package com.example.tmcandroid.presentation.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.tmcandroid.databinding.ActivityBasicBinding
import dagger.hilt.android.AndroidEntryPoint

//Step 2. Create entry point annotations for injecting dependencies.
@AndroidEntryPoint
class BasicActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBasicBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("TEST", "BasicActivity onCreate start")
            //TODO
        super.onCreate(savedInstanceState)
        binding = ActivityBasicBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


    override fun onStart() {
        Log.d("TEST", "BasicActivity onStart start")

        super.onStart()
    }

    override fun onResume() {
        Log.d("TEST", "BasicActivity onResume start")

        super.onResume()
    }

    override fun onPause() {
        Log.d("TEST", "BasicActivity onPause start")

        super.onPause()
    }

    override fun onStop() {
        Log.d("TEST", "BasicActivity onStop start")

        super.onStop()
    }

    override fun onDestroy() {
        Log.d("TEST", "BasicActivity onDestroy start")

        super.onDestroy()
    }
}