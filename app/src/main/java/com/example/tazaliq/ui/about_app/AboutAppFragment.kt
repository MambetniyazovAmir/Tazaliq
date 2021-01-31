package com.example.tazaliq.ui.about_app

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.tazaliq.R
import com.example.tazaliq.core.extentions.onClick
import com.example.tazaliq.databinding.FragmentAboutAppBinding

class AboutAppFragment : Fragment(R.layout.fragment_about_app) {

    private lateinit var binding: FragmentAboutAppBinding
    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAboutAppBinding.bind(view)
        navController = Navigation.findNavController(requireActivity(), R.id.root_nav_host)
        binding.btnBack.onClick {
            navController.popBackStack()
        }
    }
}