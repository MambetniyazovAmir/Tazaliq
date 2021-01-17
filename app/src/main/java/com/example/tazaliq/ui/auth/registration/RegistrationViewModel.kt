package com.example.tazaliq.ui.auth.registration

import androidx.lifecycle.ViewModel
import com.example.tazaliq.data.firebase.AuthHelper
import com.google.firebase.auth.FirebaseUser

class RegistrationViewModel(private val authHelper: AuthHelper) : ViewModel() {
    fun signUp(email: String, password: String,
               onSuccess: (currentUser: FirebaseUser) -> Unit, onFailure: (msg: String?) -> Unit) {
        authHelper.signUp(email, password, onSuccess, onFailure)
    }
}