package com.example.tazaliq.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.example.tazaliq.R
import com.example.tazaliq.databinding.FragmentMainBinding

class MainFragment: Fragment(R.layout.fragment_main) {

    private lateinit var fragmentMainBinding: FragmentMainBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentMainBinding = FragmentMainBinding.bind(view)
        val navController = Navigation.findNavController(requireActivity(), R.id.mainNavHost)
        fragmentMainBinding.bottomNavigation.setupWithNavController(navController)
    }
}