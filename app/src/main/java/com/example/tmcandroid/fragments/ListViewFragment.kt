package com.example.tmcandroid.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.tmcandroid.adapters.MyListViewAdapter
import com.example.tmcandroid.R
import com.example.tmcandroid.data.User
import com.example.tmcandroid.databinding.ListviewFragmentBinding
import kotlin.random.Random

class ListViewFragment : Fragment() {

    private var _binding: ListviewFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = ListviewFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.nextButton.setOnClickListener {
            findNavController().navigate(R.id.action_ListViewFragment_to_RecyclerViewFragment)
        }
        createMonthSpinner()
        createYearSpinner()
        createListView()
    }

    /**
     * This method creates the ListView from Array<User>
     *     using MyListViewAdapter and userFactory() method.
     */
    private fun createListView() {
        binding.listViewId.apply {
            adapter = MyListViewAdapter(requireActivity(), userFactory())
        }

        //NOT REALISED
        // OnClick Event that will display the Name of the Item in a toast
//        itemsListView.setOnItemClickListener { parent, view, position, id ->
//            val element = adapter.getItem(position)
//            toast(element.toString())
    }

    private fun userFactory() : Array<User> {
        return Array(30) {i -> User("User$i", i, Random.nextInt(20, 300)) }
    }

    /**
     * This method creates the MonthSpinner from the array "month"
     * and shows a short message
     */
    private fun createMonthSpinner() {
        val months = Array(12) {i -> (i + 1).toString()}
        binding.spinnerMonthFragmentTwo.apply {
            adapter = ArrayAdapter(requireActivity().baseContext,
                android.R.layout.simple_spinner_item,
                months)
        }

        //SHOW TOAST
        binding.spinnerMonthFragmentTwo.apply {
            onItemSelectedListener =  object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    Toast.makeText(requireActivity(),
                        months[p2], Toast.LENGTH_SHORT).show()
                }
                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }
        }
    }

    /**
     * This method creates the YearSpinner from the array "years"
     * and shows a short message
     */
    private fun createYearSpinner() {
        val years = Array(10) {i -> (2023 - i).toString()}
        binding.spinnerYearFragmentTwo.apply {
            adapter = ArrayAdapter(requireActivity().baseContext,
                android.R.layout.simple_spinner_item,
                years)
        }

        //SHOW TOAST
        binding.spinnerYearFragmentTwo.apply {
            onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    Toast.makeText(requireActivity(),
                        years[p2], Toast.LENGTH_SHORT).show()
                }
                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }
        }
    }

}