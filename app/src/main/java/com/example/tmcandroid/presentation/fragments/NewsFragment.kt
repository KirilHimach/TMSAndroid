package com.example.tmcandroid.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmcandroid.R
import com.example.tmcandroid.presentation.adapters.NewsFragmentAdapter
import com.example.tmcandroid.databinding.FragmentNewsBinding
import com.example.tmcandroid.di.base.DaggerDaggerComponent
import com.example.tmcandroid.di.modules.ViewModelFactory
import com.example.tmcandroid.domain.models.PostNews
import com.example.tmcandroid.presentation.view_models.PostsNewsViewModel
import java.lang.IllegalStateException
import javax.inject.Inject


class NewsFragment : Fragment() {
    private lateinit var binding: FragmentNewsBinding

   // private val postNewsViewModel: PostsNewsViewModel by viewModel()

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private var _postNewsViewModel: PostsNewsViewModel? = null
    private val postNewsViewModel: PostsNewsViewModel get() =
        _postNewsViewModel ?: throw IllegalStateException("PostNewsViewModel is not found")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.application?.let {
            DaggerDaggerComponent.factory().create(it).inject(this)
        }
        _postNewsViewModel = viewModelFactory.create(PostsNewsViewModel::class.java)
    }

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
                items = posts,
                onItemClickListener = {
                    findNavController()
                        .navigate(R.id.action_NewsFragment_to_Info_Fragment)
                }
            )
        }
    }
}