package com.example.tazaliq.ui.want_franchise

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.tazaliq.R
import com.example.tazaliq.core.extentions.onClick
import com.example.tazaliq.databinding.FragmentFranchiseBinding
import kotlinx.android.synthetic.main.activity_main.*

class FranchiseFragment : Fragment(R.layout.fragment_franchise) {

    private lateinit var binding: FragmentFranchiseBinding
    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFranchiseBinding.bind(view)
        navController = Navigation.findNavController(requireActivity(), R.id.root_nav_host)
        binding.btnBack.onClick {
            navController.popBackStack()
        }
    }
}