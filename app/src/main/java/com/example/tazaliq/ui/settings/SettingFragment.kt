package com.example.tazaliq.ui.settings

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.tazaliq.R
import com.example.tazaliq.core.extentions.onClick
import com.example.tazaliq.data.firebase.ProfileHelper
import com.example.tazaliq.databinding.FragmentSettingsBinding
import com.example.tazaliq.ui.main.MainFragmentDirections

class SettingFragment : Fragment(R.layout.fragment_settings) {

    private lateinit var navController: NavController
    private lateinit var binding: FragmentSettingsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSettingsBinding.bind(view)
        navController = Navigation.findNavController(view)
        val action = MainFragmentDirections.actionMainFragmentToEditProfileFragment()
        binding.tvEditProfile.onClick {
            navController.navigate(action)
        }
    }
}