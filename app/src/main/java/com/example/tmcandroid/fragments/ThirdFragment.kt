package com.example.tmcandroid.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmcandroid.adapters.MyRecyclerViewAdapter
import com.example.tmcandroid.databinding.FragmentThirdBinding
import kotlin.random.Random


class ThirdFragment : Fragment() {
    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createRecycler()
    }

    /**
     * This method creates the RecyclerView from Array<User>
     *     using MyRecyclerViewAdapter and userFactory() method.
     */
    private fun createRecycler() {
        binding.recyclerViewId.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = MyRecyclerViewAdapter(userFactory())
        }
    }

    private fun userFactory() : Array<User> {
        return Array(70) {i -> User("User$i", i, Random.nextInt(20, 300)) }
    }
}