package com.example.tazaliq.ui.auth.registration

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.tazaliq.R
import com.example.tazaliq.core.BaseFragment
import com.example.tazaliq.core.extentions.onClick
import com.example.tazaliq.ui.MainActivity
import com.example.tazaliq.ui.auth.login.LoginFragmentDirections
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.fragment_registration.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegistrationFragment : BaseFragment(R.layout.fragment_registration) {
    private val viewModel: RegistrationViewModel by viewModel()
    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        btnRegister.onClick {
            if (etEmail.text.isNullOrEmpty() || etPassword.text.isNullOrEmpty() || etPasswordConfirm.text.isNullOrEmpty()) {
                toastSH(getString(R.string.please_fill_all_fields))
            } else {
                if (etPassword.text.toString() == etPasswordConfirm.text.toString()) {
                    viewModel.signUp(etEmail.text.toString(), etPassword.text.toString(), onSignInSuccess, onSignInFailure)
                } else {
                    toastSH("Пароллер мас емес дегеннин орысшасы")
                }
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