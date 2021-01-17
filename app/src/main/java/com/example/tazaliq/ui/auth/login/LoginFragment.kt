package com.example.tazaliq.ui.auth.login

import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.tazaliq.R
import com.example.tazaliq.core.BaseFragment
import com.example.tazaliq.core.extentions.onClick
import com.example.tazaliq.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseUser
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : BaseFragment(R.layout.fragment_login) {

    private val viewModel: LoginViewModel by viewModel()
    private lateinit var navController: NavController
    private lateinit var binding: FragmentLoginBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)
        navController = Navigation.findNavController(view)
        binding.btnRegister.onClick {
            val action = LoginFragmentDirections.actionLoginFragmentToRegistrationFragment2()
            navController.navigate(action)
        }
        binding.btnLogin.onClick {
            if (binding.etEmail.text.isNullOrEmpty() || binding.etPassword.text.isNullOrEmpty()) {
                toastSH(getString(R.string.please_fill_all_fields))
            } else {
                viewModel.signIn(
                    binding.etEmail.text.toString(),
                    binding.etPassword.text.toString(),
                    onSignInSuccess,
                    onSignInFailure
                )
            }
        }
    }

    private val onSignInSuccess: (user: FirebaseUser) -> Unit = {
        val action = LoginFragmentDirections.actionLoginFragmentToMainFragment()
        navController.navigate(action)
    }

    private val onSignInFailure: (msg: String?) -> Unit = {
        toastLN(it)
    }
}
