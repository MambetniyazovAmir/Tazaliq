package com.example.tazaliq.ui.want_franchise

import android.os.Bundle
import android.telephony.SmsManager
import android.view.View
import android.widget.ArrayAdapter
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.tazaliq.R
import com.example.tazaliq.core.BaseFragment
import com.example.tazaliq.core.ResourceState
import com.example.tazaliq.core.extentions.onClick
import com.example.tazaliq.core.extentions.visibility
import com.example.tazaliq.data.model.City
import com.example.tazaliq.databinding.FragmentFranchiseBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class FranchiseFragment : BaseFragment(R.layout.fragment_franchise) {

    private lateinit var binding: FragmentFranchiseBinding
    private lateinit var navController: NavController
    private val viewModel: FranchiseViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFranchiseBinding.bind(view)
        navController = Navigation.findNavController(requireActivity(), R.id.root_nav_host)
        binding.btnBack.onClick {
            navController.popBackStack()
        }
        binding.btnSend.onClick {
            sendSMS(
                "+998913021226",
                binding.etName.text.toString() + "\n" + binding.etMessageText.text.toString() + "\n" + binding.spCity.selectedItem.toString()
            )
        }
        viewModel.getAllCities()
        setObservers()
    }

    private fun setObservers() {
        viewModel.cities.observe(viewLifecycleOwner) { res ->
            when (res.status) {
                ResourceState.LOADING -> binding.progressBar.visibility(true)
                ResourceState.SUCCESS -> {
                    res.data?.let {
                        if (it.isNotEmpty()) {
                            binding.spCity.adapter = ArrayAdapter<City>(
                                requireContext(),
                                android.R.layout.simple_spinner_dropdown_item,
                                it
                            )
                        }
                        binding.progressBar.visibility(false)
                    }
                }
                ResourceState.ERROR -> {
                    toastLN(res.message)
                    binding.progressBar.visibility(false)
                }
            }
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