package com.example.tmcandroid.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmcandroid.R
import com.example.tmcandroid.adapters.NewsFragmentAdapter
import com.example.tmcandroid.data.*
import com.example.tmcandroid.data.FakeUser
import com.example.tmcandroid.databinding.FragmentNewsBinding


class NewsFragment : Fragment() {
    private var _binding: FragmentNewsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val newsFragmentAdapter = NewsFragmentAdapter()
        onCreateRecycler(newsFragmentAdapter)
        newsListener(newsFragmentAdapter)
    }

    /**
     * I will try to explain the "data" folder step by step here.
     *
     * First of all, this method is used to display FakeUsers in the Recycler.
     * 1. The application is connected to the Internet.
     * 2. The FakeUserResponse class is a model of the response
     * from the server in Json format. Link to the website - https://randomuser.me
     * 3. StartModel creates the FakeUserFactory object
     * and starts the getFakeUserResponse() method in the coroutine.
     * 4. The FakeUserFactory uses the FakeUserInterface interface
     * and receives a response from the server.
     * 5. We get a fixed list of 50 users. We can change this value
     * in the FakeUserFactory.getFakeUserResponse() method.
     * 6. The FakeUserFactory.getFakeUserResponse() method
     * also uses the RetrofitInstance object to convert Json to List<FakeUser>.
     */
    @SuppressLint("SuspiciousIndentation")
    private fun onCreateRecycler(newsFragmentAdapter: NewsFragmentAdapter) {
        val viewModel = ViewModelProvider(this)[StartModel::class.java]
            binding.newsFragmentRecycler.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = newsFragmentAdapter
                viewModel.getUsersFactory()
                viewModel.users.observe(viewLifecycleOwner) { fakeUsers ->
                    fakeUsers.body()?.let {
                        newsFragmentAdapter.setFakeUsers(fakeUsers)
                    }
                }
            }
    }

    /**
     * This method uses the Observer.
     * When the user clicks on the item,
     * he calls the method onTransferToInfoFragment()
     * and passes the FakeUser object there.
     */
    private fun newsListener(newsFragmentAdapter: NewsFragmentAdapter) {
        newsFragmentAdapter.setOnClickListener(object : NewsFragmentAdapter.OnClickListener{
            override fun onClick(model: FakeUser) {
                onTransferToInfoFragment(model)
            }
        })
    }

    /**
     *This method uses navigation tools.
     * He goes to the info fragment and passes the object to the FakeUser.
     * The "data.FakeUser" class also implements
     * an interface for serialization/deserialization.
     */
    private fun onTransferToInfoFragment(fakeUserInfo: FakeUser) {
        findNavController()
            .navigate(R.id.action_NewsFragment_to_Info_Fragment,
                 bundleOf("key" to fakeUserInfo))
    }
}


