package com.example.tazaliq.ui.edit_profile

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.tazaliq.R
import com.example.tazaliq.core.BaseFragment
import com.example.tazaliq.core.ResourceState
import com.example.tazaliq.core.extentions.onClick
import com.example.tazaliq.core.extentions.visibility
import com.example.tazaliq.data.model.City
import com.example.tazaliq.databinding.FragmentEditProfileBinding
import kotlinx.android.synthetic.main.fragment_profile.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class EditProfileFragment : BaseFragment(R.layout.fragment_edit_profile) {

    private val viewModel: EditProfileViewModel by viewModel()
    private lateinit var binding: FragmentEditProfileBinding
    private lateinit var navController: NavController
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentEditProfileBinding.bind(view)
        setObservers()
        navController = Navigation.findNavController(requireActivity(), R.id.root_nav_host)
        viewModel.getUser()
        viewModel.getAllCities()
        binding.btnDone.onClick {
            viewModel.cities.value?.data?.get(binding.spCity.selectedItemPosition)?.let { it1 ->
                viewModel.editProfile(
                    binding.etName.text.toString(),
                    it1.id,
                    binding.etStatus.text.toString(),
                    binding.etAbout.text.toString(),
                    onSuccess,
                    onFailure
                )
            }
        }
        binding.btnCancel.onClick {
            navController.popBackStack()
        }
    }

    private val onSuccess: () -> Unit = {
        navController.popBackStack()
    }

    private val onFailure: (msg: String?) -> Unit = {
        toastLN(it)
    }

    private fun setObservers() {
        viewModel.cities.observe(viewLifecycleOwner, { res ->
            when (res.status) {
                ResourceState.LOADING -> progressBar.visibility(true)
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
        })
        viewModel.user.observe(viewLifecycleOwner, { res ->
            when (res.status) {
                ResourceState.LOADING -> progressBar.visibility(true)
                ResourceState.SUCCESS -> {
                    res.data?.let {
                        if (it.name.isNotEmpty())
                            binding.etName.setText(it.name)
                        if (it.status.isNotEmpty())
                            binding.etStatus.setText(it.status)
                        if (it.about.isNotEmpty())
                            binding.etAbout.setText(it.about)
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