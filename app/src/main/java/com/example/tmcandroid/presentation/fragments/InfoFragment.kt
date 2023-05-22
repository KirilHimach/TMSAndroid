package com.example.tmcandroid.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.tmcandroid.R
import com.example.tmcandroid.databinding.FragmentInfoBinding
import com.example.tmcandroid.domain.models.PostInfo
import com.example.tmcandroid.presentation.view_models.PostInfoViewModel
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

//Step 2. Create entry point annotations for injecting dependencies.
@AndroidEntryPoint
class InfoFragment : Fragment() {

    private lateinit var binding: FragmentInfoBinding
    private val postsInfoViewModel: PostInfoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val postInfo = postsInfoViewModel.postInfo.value ?: PostInfo()
        enableToolbar()
        showInfoFragment(postInfo)
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
     * This method fills in the fields of the card.
     */
    private fun showInfoFragment(postInfo: PostInfo) {
//        binding.infoName.text = postInfo.name
//        binding.infoLocation.text = postInfo.location
//        binding.infoBirthday.append(" ${postInfo.dob}")
//        binding.infoAge.text = "36" //TODO
//        binding.infoEmail.text = postInfo.email
//        binding.infoPhone.text = postInfo.phone
//        Picasso.get()
//            .load(postInfo.picture)
//            .into(binding.infoImage)
    }
}