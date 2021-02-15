package com.example.tazaliq.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.example.tazaliq.R
import com.example.tazaliq.core.BaseFragment
import com.example.tazaliq.core.ResourceState
import com.example.tazaliq.core.extentions.onClick
import com.example.tazaliq.core.extentions.visibility
import com.example.tazaliq.databinding.FragmentProfileBinding
import com.example.tazaliq.ui.CaptureActivity
import com.google.zxing.integration.android.IntentIntegrator
import kotlinx.android.synthetic.main.fragment_profile.*
import org.json.JSONException
import org.json.JSONObject
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfileFragment : BaseFragment(R.layout.fragment_profile) {
    private val viewModel: ProfileViewModel by viewModel()
    private lateinit var binding: FragmentProfileBinding
    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProfileBinding.bind(view)
        navController = Navigation.findNavController(view)
        setObservers()
        viewModel.getUser()
        binding.btnSettings.onClick {
            val action = ProfileFragmentDirections.actionProfileFragmentToSettingFragment()
            navController.navigate(action)
        }
        binding.btnQRCode.onClick {
            scanQRCode()
        }
    }

    private fun scanQRCode() {
        val integrator = IntentIntegrator.forSupportFragment(this).apply {
            captureActivity = CaptureActivity::class.java
            setOrientationLocked(false)
            setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES)
            setPrompt("Scanning Code")
        }
        integrator.initiateScan()
    }

    private fun setObservers() {
        viewModel.user.observe(viewLifecycleOwner, { res ->
            when (res.status) {
                ResourceState.LOADING -> progressBar.visibility(true)
                ResourceState.SUCCESS -> {
                    res.data?.let {
                        if (it.name.isNotEmpty())
                            binding.tvName.text = it.name
                        if (it.status.isNotEmpty())
                            binding.tvStatus.text = it.status
                        if (it.about.isNotEmpty())
                            binding.tvAboutValue.text = it.about
                        if (it.imageUrl.isNotEmpty())
                            Glide.with(this).load(it.imageUrl).centerCrop().into(binding.imgAvatar)
                    }
                    binding.progressBar.visibility(false)
                }
                ResourceState.ERROR -> {
                    toastLN(res.message)
                    binding.progressBar.visibility(false)
                }
            }
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            if (result.contents == null) toastLN("Cancelled")
            else {
                try {
                    // Converting the data to json format
                    val obj = JSONObject(result.contents)
                    // Show values in UI.
                    binding.tvMarket.text = result.contents

                } catch (e: JSONException) {
                    e.printStackTrace()
                    // Data not in the expected format. So, whole object as toast message.
                    Toast.makeText(activity, result.contents, Toast.LENGTH_LONG).show()
                }
            }
        } else
            super.onActivityResult(requestCode, resultCode, data)
    }
}