package com.example.tmcandroid.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.tmcandroid.R
import com.example.tmcandroid.databinding.FragmentInfoBinding
import com.example.tmcandroid.domain.models.PostNews
import com.example.tmcandroid.presentation.view_models.PostInfoViewModel
import com.squareup.picasso.Picasso
import org.koin.androidx.viewmodel.ext.android.viewModel


class InfoFragment : Fragment() {

    private lateinit var binding: FragmentInfoBinding
    private val postsInfoViewModel: PostInfoViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        enableToolbar()

        postsInfoViewModel.postInfo.observe(viewLifecycleOwner) { postNewsInfo ->
            showInfoFragment(postNewsInfo)
        }

    }

    private fun enableToolbar() {
        binding.infoToolbar.setOnClickListener {
            findNavController().navigate(R.id.action_Info_Fragment_to_News_Fragment)
        }
    }

    private fun showInfoFragment(postNewsInfo: PostNews) {
        binding.infoName.text = postNewsInfo.author
        binding.infoBirthday.append("${postNewsInfo.publishedAt}")
        binding.infoAge.text = postNewsInfo.description

        Picasso.get()
            .load(postNewsInfo.urlToImage)
            .into(binding.infoImage)


        // binding.infoLocation.text = postNewsInfo.author
        // binding.infoEmail.text = postNewsInfo.content
        //   binding.infoPhone.text = postInfo.phone
    }
}