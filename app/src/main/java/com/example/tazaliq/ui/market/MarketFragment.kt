package com.example.tazaliq.ui.market

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.tazaliq.R
import com.example.tazaliq.core.BaseFragment
import com.example.tazaliq.core.ResourceState
import com.example.tazaliq.core.extentions.onClick
import com.example.tazaliq.core.extentions.visibility
import com.example.tazaliq.databinding.FragmentMarketBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MarketFragment : BaseFragment(R.layout.fragment_market) {

    private val adapter = MarketAdapter(R.layout.product_row_item)
    private val viewModel: MarketViewModel by viewModel()
    private lateinit var navController: NavController
    private lateinit var binding: FragmentMarketBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMarketBinding.bind(view)
        navController = Navigation.findNavController(view)

        binding.btnBack.onClick {
            navController.popBackStack()
        }
        setObservers()
        viewModel.getProducts()
        binding.productsRecyclerview.adapter = adapter
    }

    private fun setObservers() {
        viewModel.products.observe(viewLifecycleOwner) { res ->
            when (res.status) {
                ResourceState.LOADING -> binding.progressBar.visibility(true)
                ResourceState.SUCCESS -> res.data?.let {
                    binding.progressBar.visibility(false)
                    adapter.models = it
                }
                ResourceState.ERROR -> toastLN(res.message)
            }
        }
    }
}