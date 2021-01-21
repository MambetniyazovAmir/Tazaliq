package com.example.tazaliq.ui.settings

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.tazaliq.R
import com.example.tazaliq.databinding.FragmentSettingsBinding

class SettingFragment : Fragment(R.layout.fragment_settings) {

    private lateinit var navController: NavController
    private lateinit var binding: FragmentSettingsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSettingsBinding.bind(view)
        navController = Navigation.findNavController(view)
    }

}