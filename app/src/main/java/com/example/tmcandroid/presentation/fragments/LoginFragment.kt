package com.example.tmcandroid.presentation.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.navigation.fragment.findNavController
import com.example.tmcandroid.R
import com.example.tmcandroid.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.e("TEST", "LoginFragment onCreateView start")
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.e("TEST", "LoginFragment onViewCreated start")

        super.onViewCreated(view, savedInstanceState)
        onEnableBtnAndTransferToNewsFragment()
    }

    /**
     * First of all, this method responds to changes
     * in the user and password field.
     * If two conditions are true, then the button is enable.
     */
    private fun onEnableBtnAndTransferToNewsFragment() {
        binding.usernameEditText.doOnTextChanged { usernameEditText, start, before, count ->
            if (usernameEditText != null) {
                binding.logInButton.isEnabled =
                    usernameEditText.isNotEmpty() && binding.passwordEditText.length() >=8
            }
        }
        binding.passwordEditText.doOnTextChanged { passwordEditText, start, before, count ->
            if (passwordEditText != null) {
                binding.logInButton.isEnabled =
                    passwordEditText.length >= 8 && binding.usernameEditText.length() > 0
            }
        }
        binding.logInButton.setOnClickListener {
            findNavController().navigate(R.id.action_LoginFragment_to_NewsFragment)
            //TODO test Firebase
                //throw Exception("Press login button")
        }
    }



    //TODO Test Livecycle
    override fun onStart() {
        Log.e("TEST", "LoginFragment onStart start")

        super.onStart()
    }

    override fun onResume() {
        Log.e("TEST", "LoginFragment onResume start")

        super.onResume()
    }

    override fun onPause() {
        Log.e("TEST", "LoginFragment onPause start")

        super.onPause()
    }

    override fun onStop() {
        Log.e("TEST", "LoginFragment onStop start")

        super.onStop()
    }

    override fun onAttach(context: Context) {
        Log.e("TEST", "LoginFragment onAttach start")

        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.e("TEST", "LoginFragment onCreate start")

        super.onCreate(savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.e("TEST", "LoginFragment onActivityCreated start")

        super.onActivityCreated(savedInstanceState)
    }

    override fun onDestroyView() {
        Log.e("TEST", "LoginFragment onDestroyView start")

        super.onDestroyView()
    }

    override fun onDestroy() {
        Log.e("TEST", "LoginFragment onDestroy start")

        super.onDestroy()
    }

    override fun onDetach() {
        Log.e("TEST", "LoginFragment onDetach start")

        super.onDetach()
    }
}