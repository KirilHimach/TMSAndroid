package com.example.tmcandroid.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmcandroid.adapters.MyRecyclerViewAdapter
import com.example.tmcandroid.data.FakeUser
import com.example.tmcandroid.data.FakeUserFactory
import com.example.tmcandroid.databinding.RecyclerviewFragmentBinding
import kotlin.random.Random


class RecyclerViewFragment : Fragment() {
    private var _binding: RecyclerviewFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = RecyclerviewFragmentBinding.inflate(inflater, container, false)
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

    private fun userFactory() : List<FakeUser> {
        return FakeUserFactory().getFakeUser()
    }
}