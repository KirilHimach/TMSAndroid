package com.example.tmcandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.tmcandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toFirst.setOnClickListener {
            onNextFragment(FirstFragment())
        }

        binding.toSecond.setOnClickListener {
            onNextFragment(SecondFragment())
        }
    }

    private fun onNextFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.main_fragment_container, fragment)
            .commit()
    }
}