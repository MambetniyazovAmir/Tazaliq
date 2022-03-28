package com.example.tazaliq.ui.rating

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import com.example.tazaliq.R
import com.example.tazaliq.core.BaseFragment
import com.example.tazaliq.core.ResourceState
import com.example.tazaliq.core.extentions.visibility
import com.example.tazaliq.data.model.City
import com.example.tazaliq.databinding.FragmentRatingBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class RatingFragment : BaseFragment(R.layout.fragment_rating) {

    private val adapter = RatingAdapter(R.layout.rating_item_view)
    private val viewModel: RatingViewModel by viewModel()
    private lateinit var binding: FragmentRatingBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRatingBinding.bind(view)
        setObservers()
        viewModel.getAllCities()
        viewModel.getUsers()
        binding.list.adapter = adapter
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
        viewModel.users.observe(viewLifecycleOwner) { res ->
            when (res.status) {
                ResourceState.LOADING -> toastLN("loading")
                ResourceState.SUCCESS -> {
                    res.data?.let {
                        adapter.models = it
                    }
                }
                ResourceState.ERROR -> {
                    toastLN(res.message)
                }
            }
        }
    }
}
