package com.example.tazaliq.ui.about

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.tazaliq.R
import com.example.tazaliq.databinding.FragmentAboutBinding
import com.example.tazaliq.ui.about.adapter.AboutAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class AboutFragment: Fragment(R.layout.fragment_about) {

    private val viewModel: AboutViewModel by viewModel()
    private val adapter = AboutAdapter()
    private lateinit var binding: FragmentAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.aboutList.observe(this, Observer {
            adapter.setData(it)
        })
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAboutBinding.bind(view)
        binding.list.adapter = adapter
        binding.list.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
    }
}