package com.example.tmcandroid

import android.os.Bundle
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.navigation.fragment.findNavController
import com.example.tmcandroid.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        goToSecondFragment()
    }

    private fun goToSecondFragment() {
        var passwordCount = 0
        var loginCount = 0
        binding.passwordEditText.doOnTextChanged { text, start, before, count ->
            passwordCount = text!!.length
            enableButton(passwordCount, loginCount)
        }
        binding.usernameEditText.doOnTextChanged { text, start, before, count ->
            loginCount = text!!.length
            enableButton(passwordCount, loginCount)
        }
        binding.logInButton.setOnClickListener {
                findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }
    private fun enableButton(password: Int, login: Int) {
        binding.logInButton.isEnabled = password >= 8 && login > 0
    }

}