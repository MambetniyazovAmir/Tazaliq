package com.example.tazaliq.ui.splash

import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.tazaliq.R
import com.example.tazaliq.core.BaseFragment
import com.google.firebase.auth.FirebaseAuth
import org.koin.android.ext.android.inject

class SplashFragment : BaseFragment(R.layout.fragment_splash) {
    private val firebaseAuth: FirebaseAuth by inject()
    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        if (firebaseAuth.currentUser == null) {
            val action = SplashFragmentDirections.actionSplashFragmentToLoginFragment()
            navController.navigate(action)
        } else {
            val action = SplashFragmentDirections.actionSplashFragmentToMainFragment()
            navController.navigate(action)
        }
    }
}