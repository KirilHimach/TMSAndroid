package com.example.tmcandroid.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.tmcandroid.R
import com.example.tmcandroid.data.*
import com.example.tmcandroid.databinding.FragmentInfoBinding
import com.squareup.picasso.Picasso


class InfoFragment : Fragment() {
    private var _binding: FragmentInfoBinding? = null
    private val binding get() = _binding!!
    private var fakeUserInfo: FakeUser? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        enableToolbar()
        newsFragmentListener()
    }

    /**
     * This method listens for clicking on
     * the back button in the toolbar.
     * When the button is pressed, we go to the news fragment.
     */
    private fun enableToolbar() {
        binding.infoToolbar.setOnClickListener {
            findNavController().navigate(R.id.action_Info_Fragment_to_News_Fragment)
        }
    }

    /**
     * This method uses navigation tools
     * and takes data from a news fragment.
     * It deserializes the user object and calls the showInfoFragment() method.
     */
    private fun newsFragmentListener() {
        fakeUserInfo = arguments?.getSerializable("key") as FakeUser
        showInfoFragment()
    }

    /**
     * This method fills in the fields of the card.
     */
    private fun showInfoFragment() {
        val name = fakeUserInfo?.name?.first  + " " + fakeUserInfo?.name?.last
        val location = fakeUserInfo?.location?.country +
                ", " + fakeUserInfo?.location?.state +
                ", " + fakeUserInfo?.location?.city
        val birthday = fakeUserInfo?.dob?.date?.substringBefore('T') ?: "Unknown"
        val age = fakeUserInfo?.dob?.age
        binding.infoName.text = name
        binding.infoLocation.text = location
        binding.infoBirthday.append(" $birthday")
        binding.infoAge.append(" $age")
        binding.infoEmail.text = fakeUserInfo?.email
        binding.infoPhone.text = fakeUserInfo?.phone
        Picasso.get()
            .load(fakeUserInfo?.picture?.large)
            .into(binding.infoImage)
    }
}