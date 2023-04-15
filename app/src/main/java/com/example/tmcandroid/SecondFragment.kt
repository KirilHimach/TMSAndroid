package com.example.tmcandroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.tmcandroid.databinding.FragmentSecondBinding
import kotlin.random.Random

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.nextButton.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_ThirdFragment)
        }
        createMonthSpinner()
        createYearSpinner()
        createListView()
    }

    private fun createListView() {
        val users =
            Array(30) {i -> User("User$i", i, Random.nextInt())}

        val myAdapter = MyListViewAdapter(requireActivity(), users)
        val itemList = binding.listViewId
        itemList.adapter = myAdapter
    }

    private fun createMonthSpinner() {
        val months = Array(12) {i -> (i + 1).toString()}
        val spinner: Spinner = binding.spinnerMonthFragmentTwo
        val adapter: ArrayAdapter<String> =
            ArrayAdapter(requireActivity().baseContext,
                android.R.layout.simple_spinner_item,
                months)
        spinner.adapter = adapter

        //SHOW TOAST
        spinner.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    Toast.makeText(requireActivity(),
                        months[p2], Toast.LENGTH_SHORT).show()
                }
                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }
    }

    private fun createYearSpinner() {
        val years = Array(10) {i -> (2023 - i).toString()}
        val spinner: Spinner = binding.spinnerYearFragmentTwo
        val adapter: ArrayAdapter<String> =
            ArrayAdapter(requireActivity().baseContext,
                android.R.layout.simple_spinner_item,
                years)
        spinner.adapter = adapter


        //SHOW TOAST
        spinner.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
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