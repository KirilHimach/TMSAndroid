package com.example.tmcandroid.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmcandroid.R
import com.example.tmcandroid.presentation.adapters.NewsFragmentAdapter
import com.example.tmcandroid.databinding.FragmentNewsBinding
import com.example.tmcandroid.domain.models.PostNewsList
import com.example.tmcandroid.presentation.view_models.PostsNewsViewModel


class NewsFragment : Fragment() {
    private lateinit var binding: FragmentNewsBinding
    private var postNewsViewModel: PostsNewsViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        postNewsViewModel = ViewModelProvider(this)[PostsNewsViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onCreateRecycler()
    }


    private fun onCreateRecycler() {
        val postsNews = postNewsViewModel?.postNewsList?.value ?: PostNewsList()
        binding.newsFragmentRecycler.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = NewsFragmentAdapter(
                items = postsNews,
                onItemClickListener = {
                    findNavController()
                        .navigate(R.id.action_NewsFragment_to_Info_Fragment)
                }
            )
        }
    }
}