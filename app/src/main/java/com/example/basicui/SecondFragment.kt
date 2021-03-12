package com.example.basicui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.basicui.databinding.FragmentSecondBinding
import splitties.activities.start

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {
    private lateinit var binding : FragmentSecondBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentSecondBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setListenersButtons()
    }

    private fun setListenersButtons(){
        binding.backToFragment1Button.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

        binding.openUrlButton.setOnClickListener{
            browse("https://thatskygame.com/")
        }

        binding.shareApplicationButton.setOnClickListener(){
            requireContext().share(R.string.text_share, R.string.title_share)
        }

        binding.startActivityButton.setOnClickListener(){
            requireContext().start<SecondaryActivity>()
        }
    }


    private fun browse(url: String) {
        var browser = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(browser)
    }
}