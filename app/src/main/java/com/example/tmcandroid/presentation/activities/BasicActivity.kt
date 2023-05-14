package com.example.tmcandroid.presentation.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tmcandroid.databinding.ActivityBasicBinding
import dagger.hilt.android.AndroidEntryPoint

//Step 2. Create entry point annotations for injecting dependencies.
@AndroidEntryPoint
class BasicActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBasicBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBasicBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}