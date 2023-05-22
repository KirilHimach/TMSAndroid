package com.example.tmcandroid.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmcandroid.R
import com.example.tmcandroid.presentation.adapters.NewsFragmentAdapter
import com.example.tmcandroid.databinding.FragmentNewsBinding
import com.example.tmcandroid.domain.models.PostNews
import com.example.tmcandroid.presentation.view_models.PostsNewsViewModel
import dagger.hilt.android.AndroidEntryPoint

//Step 2. Create entry point annotations for injecting dependencies.
@AndroidEntryPoint
class NewsFragment : Fragment() {
    private lateinit var binding: FragmentNewsBinding
    private val postNewsViewModel: PostsNewsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observePosts()
    }

    private fun observePosts() {
        postNewsViewModel.postNewsList.observe(viewLifecycleOwner) { posts ->
            onCreateRecycler(posts)
        }
    }


    private fun onCreateRecycler(posts: List<PostNews>) {
        binding.newsFragmentRecycler.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = NewsFragmentAdapter(
                context = context,
                items = posts,
                onItemClickListener = {
                    findNavController()
                        .navigate(R.id.action_NewsFragment_to_Info_Fragment)
                }
            )
        }
    }
}