package com.example.tmcandroid.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.navigation.fragment.findNavController
import com.example.tmcandroid.R
import com.example.tmcandroid.databinding.LoginFragmentBinding

class LoginFragment : Fragment() {

    private var _binding: LoginFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = LoginFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        goToSecondFragment()
    }

    /**
     * First of all, this method reacts on changes in
     * passwordEditText and usernameEditText. When there are changes,
     * the method will call enableButton() method and active/deactivate button.
     */
    private fun goToSecondFragment() {
        var passwordLength = 0
        var loginLength = 0
        binding.passwordEditText.doOnTextChanged { text, start, before, count ->
             if (text != null) {
                 passwordLength = text.length
                 enableButton(passwordLength, loginLength)
            }
        }
        binding.usernameEditText.doOnTextChanged { text, start, before, count ->
            if (text != null) {
                loginLength = text.length
                enableButton(passwordLength, loginLength)
            }
        }
        binding.logInButton.setOnClickListener {
                findNavController().navigate(R.id.action_LoginFragment_to_ListViewFragment)
        }
    }

    private fun enableButton(password: Int, login: Int) {
        binding.logInButton.isEnabled = password >= 8 && login > 0
    }

}