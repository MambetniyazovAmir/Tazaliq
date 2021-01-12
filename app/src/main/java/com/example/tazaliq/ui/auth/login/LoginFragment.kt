package com.example.tazaliq.ui.auth.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.tazaliq.R
import com.example.tazaliq.core.BaseFragment
import com.example.tazaliq.core.extentions.onClick
import com.example.tazaliq.ui.MainActivity
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.fragment_login.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : BaseFragment(R.layout.fragment_login) {

    private val viewModel: LoginViewModel by viewModel()
    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        btnRegister.onClick {
            val action = LoginFragmentDirections.actionLoginFragmentToRegistrationFragment()
            navController.navigate(action)
        }
        btnLogin.onClick {
            if (etEmail.text.isNullOrEmpty() || etPassword.text.isNullOrEmpty()) {
                toastSH(getString(R.string.please_fill_all_fields))
            } else {
                viewModel.signIn(etEmail.text.toString(), etPassword.text.toString(), onSignInSuccess, onSignInFailure)
            }
        }
    }

    private val onSignInSuccess: (user: FirebaseUser) -> Unit = {
        val intent = Intent(requireContext(), MainActivity::class.java)
        startActivity(intent)
    }

    private val onSignInFailure: (msg: String?) -> Unit = {
        toastLN(it)
    }
}
