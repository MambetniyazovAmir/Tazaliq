package com.example.tazaliq.ui.faq

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.tazaliq.R
import com.example.tazaliq.core.BaseFragment
import com.example.tazaliq.core.ResourceState
import com.example.tazaliq.core.extentions.addVertDivider
import com.example.tazaliq.core.extentions.onClick
import com.example.tazaliq.core.extentions.visibility
import com.example.tazaliq.databinding.FragmentFaqBinding
import kotlinx.android.synthetic.main.fragment_faq.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class FAQFragment : BaseFragment(R.layout.fragment_faq) {
    private val adapter = FAQAdapter(R.layout.item_faq)
    private val viewModel: FAQViewModel by viewModel()
    private lateinit var navController: NavController
    private lateinit var binding: FragmentFaqBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        binding = FragmentFaqBinding.bind(view)
        faqList.adapter = adapter
        faqList.addVertDivider(requireContext())
        binding.actionBar.apply {
            title.text = requireContext().getText(R.string.FAQ)
            btnCancel.onClick {
                navController.popBackStack()
            }
        }
        viewModel.getFAQ()
        viewModel.faq.observe(viewLifecycleOwner, {
            when(it.status) {
                ResourceState.LOADING -> {
                    binding.loading.visibility(true)
                }
                ResourceState.SUCCESS -> {
                    binding.apply {
                        loading.visibility(false)
                        adapter.models = it.data ?: listOf()
                    }
                }
                ResourceState.ERROR -> {
                    binding.loading.visibility(false)
                    toastLN(it.message)
                }
            }
        })
    }
}