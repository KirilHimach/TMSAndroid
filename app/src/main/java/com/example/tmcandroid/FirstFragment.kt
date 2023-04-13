package com.example.tmcandroid

import android.os.Bundle
<<<<<<< HEAD
import android.util.Log
=======
>>>>>>> origin/feature/task_3_Himach
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
<<<<<<< HEAD
import androidx.core.widget.doOnTextChanged
=======
>>>>>>> origin/feature/task_3_Himach
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
<<<<<<< HEAD
        goToSecondFragment()
    }

    private fun goToSecondFragment() {
        binding.passwordEditText.doOnTextChanged { text1, start1, before1, count1 ->
            binding.logInButton.isEnabled = text1!!.length >= 8
        }
        binding.logInButton.setOnClickListener {
            if (binding.usernameEditText.length() > 0) {
=======
        checkLoginAndPassword()
    }

    private fun checkLoginAndPassword() {
        binding.logInButton.setOnClickListener {
            if (binding.passwordEditText.length() >= 8
                && binding.usernameEditText.length() > 0) {
>>>>>>> origin/feature/task_3_Himach
                findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
            }
        }
    }
}