package com.example.basicui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDialog
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.basicui.databinding.FragmentFirstBinding
import splitties.alertdialog.*
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
       setListenerButtons()
    }

    private fun setListenerButtons(){
        binding.displayShortMessageButton.setOnClickListener(){
            toast(R.string.toast_short_message)
        }
        binding.displayLongMessageButton.setOnClickListener(){
            longToast(R.string.toast_long_message)
        }
        binding.openDialogButton.setOnClickListener(){
            showAlertDialog()
        }
        binding.naviguateFragmentButton.setOnClickListener(){
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }
    private fun showAlertDialog() {
        requireContext().alertDialog {
            messageResource = R.string.dialog_message
            okButton { longToast(R.string.toast_cloe_dialog) }
            cancelButton()
        }.onShow {
            positiveButton.setText(R.string.dialog_validate)
        }.show()
    }
}