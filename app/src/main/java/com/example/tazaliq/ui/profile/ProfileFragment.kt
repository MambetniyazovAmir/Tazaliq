package com.example.tazaliq.ui.profile

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.tazaliq.R
import com.example.tazaliq.core.BaseFragment
import com.example.tazaliq.core.ResourceState
import com.example.tazaliq.core.extentions.visibility
import com.example.tazaliq.databinding.FragmentProfileBinding
import kotlinx.android.synthetic.main.fragment_profile.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfileFragment: BaseFragment(R.layout.fragment_profile) {
    private val viewModel: ProfileViewModel by viewModel()
    private lateinit var binding: FragmentProfileBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProfileBinding.bind(view)
        setObservers()
        viewModel.getUser()
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
}