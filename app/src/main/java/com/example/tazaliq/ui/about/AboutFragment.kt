package com.example.tazaliq.ui.about

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.tazaliq.R
import com.example.tazaliq.core.BaseFragment
import com.example.tazaliq.core.ResourceState
import com.example.tazaliq.core.extentions.visibility
import com.example.tazaliq.databinding.FragmentAboutBinding
import com.example.tazaliq.ui.faq.FAQAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class AboutFragment: BaseFragment(R.layout.fragment_about) {

    private val viewModel: AboutViewModel by viewModel()
    private val adapter = FAQAdapter(R.layout.item_faq)
    private lateinit var binding: FragmentAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.aboutList.observe(this, {
            when(it.status) {
                ResourceState.LOADING -> binding.loading.visibility(true)
                ResourceState.SUCCESS -> {
                    binding.loading.visibility(false)
                    adapter.models = it.data!!
                }
                ResourceState.ERROR -> {
                    binding.loading.visibility(false)
                    toastLN(it.message)
                }
            }
        })
        viewModel.getAboutList()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAboutBinding.bind(view)
        binding.list.adapter = adapter
        binding.list.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
    }
}
