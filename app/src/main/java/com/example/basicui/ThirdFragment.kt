package com.example.basicui

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.basicui.databinding.FragmentThirdBinding

/**
 * A fragment representing a list of Items.
 */
class ThirdFragment : Fragment() {

    private lateinit var binding : FragmentThirdBinding

    val items = arrayOf(Capital("Lisbonne"), Capital("Paris"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentThirdBinding.inflate(layoutInflater)
        //Recycler View
        binding.capitalRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.capitalRecyclerView.adapter = CapitalRecyclerViewAdapter(items)

        binding.backToFragment1Button.setOnClickListener{
            findNavController().navigate(R.id.action_ThirdFragment_to_FirstFragment)

        }
        return binding.root
    }

}