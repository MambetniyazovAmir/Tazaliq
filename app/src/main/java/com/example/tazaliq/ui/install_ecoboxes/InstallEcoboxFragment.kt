package com.example.tazaliq.ui.install_ecoboxes

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.tazaliq.R
import com.example.tazaliq.core.extentions.onClick
import com.example.tazaliq.databinding.FragmentInstallEcoboxBinding

class InstallEcoboxFragment : Fragment(R.layout.fragment_install_ecobox) {

    private lateinit var binding: FragmentInstallEcoboxBinding
    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentInstallEcoboxBinding.bind(view)
        navController = Navigation.findNavController(requireActivity(), R.id.root_nav_host)
        binding.btnBack.onClick {
            navController.popBackStack()
        }
    }
}