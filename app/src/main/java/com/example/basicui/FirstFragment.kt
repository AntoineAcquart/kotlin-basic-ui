package com.example.basicui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.basicui.databinding.FragmentFirstBinding
import splitties.toast.longToast
import splitties.toast.toast


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textviewFirst.text = resources.getString(R.string.txtFragment)
        binding.displayShortMessageButton.setOnClickListener(){
            toast(R.string.toast_short_message)
            //findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        binding.displayLongMessageButton.setOnClickListener(){
            longToast(R.string.toast_long_message)
        }
    }

    private fun showAlertDialog() {
        alertDialog() -> {
            messageResource = R.string.text_alert
            okButton { showAlertDialog() }
            cancelButton()
        }.onShow {
            positiveButton.setText(R.string.action_like)
        }.show()
    }
}