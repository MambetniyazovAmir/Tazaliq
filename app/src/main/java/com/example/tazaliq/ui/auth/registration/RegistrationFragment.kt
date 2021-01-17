package com.example.tazaliq.ui.auth.registration

import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.tazaliq.R
import com.example.tazaliq.core.BaseFragment
import com.example.tazaliq.core.extentions.onClick
import com.example.tazaliq.databinding.FragmentRegistrationBinding
import com.example.tazaliq.ui.auth.login.LoginFragmentDirections
import com.google.firebase.auth.FirebaseUser
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegistrationFragment : BaseFragment(R.layout.fragment_registration) {
    private val viewModel: RegistrationViewModel by viewModel()
    private lateinit var navController: NavController
    private lateinit var binding: FragmentRegistrationBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRegistrationBinding.bind(view)
        navController = Navigation.findNavController(view)
        binding.btnRegister.onClick {
            if (binding.etEmail.text.isNullOrEmpty() || binding.etPassword.text.isNullOrEmpty() || binding.etPasswordConfirm.text.isNullOrEmpty()) {
                toastSH(getString(R.string.please_fill_all_fields))
            } else {
                if (binding.etPassword.text.toString() == binding.etPasswordConfirm.text.toString()) {
                    viewModel.signUp(
                        binding.etEmail.text.toString(),
                        binding.etPassword.text.toString(),
                        onSignInSuccess,
                        onSignInFailure
                    )
                } else {
                    toastSH("Пароллер мас емес дегеннин орысшасы")
                }
            }
        }
    }

    private val onSignInSuccess: (user: FirebaseUser) -> Unit = {
        val action = RegistrationFragmentDirections.actionRegistrationFragmentToMainFragment()
        navController.navigate(action)
    }

    private val onSignInFailure: (msg: String?) -> Unit = {
        toastLN(it)
    }
}