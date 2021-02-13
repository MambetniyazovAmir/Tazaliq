package com.example.tazaliq.ui.want_franchise

import android.os.Bundle
import android.telephony.SmsManager
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.tazaliq.R
import com.example.tazaliq.core.BaseFragment
import com.example.tazaliq.core.extentions.onClick
import com.example.tazaliq.databinding.FragmentFranchiseBinding


class FranchiseFragment : BaseFragment(R.layout.fragment_franchise) {

    private lateinit var binding: FragmentFranchiseBinding
    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFranchiseBinding.bind(view)
        navController = Navigation.findNavController(requireActivity(), R.id.root_nav_host)
        binding.btnBack.onClick {
            navController.popBackStack()
        }
        binding.btnSend.onClick {
            sendSMS("+998913021226", binding.etName.text.toString() + "\n" + binding.etMessageText.text.toString() + "\n" + binding.tvCity.text)
        }
    }

    private fun sendSMS(phoneNum: String, msg: String) {
        try {
            val smsManager: SmsManager = SmsManager.getDefault()
            smsManager.sendTextMessage(phoneNum, null, msg, null, null)
            toastLN("SMS send")
        } catch (ex: Exception) {
            toastLN(ex.message)
            ex.printStackTrace()
        }
    }
}