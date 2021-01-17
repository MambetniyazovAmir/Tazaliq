package com.example.tazaliq.ui.auth.login

import androidx.lifecycle.ViewModel
import com.example.tazaliq.data.firebase.AuthHelper
import com.google.firebase.auth.FirebaseUser

class LoginViewModel(private val authHelper: AuthHelper) : ViewModel() {
    fun signIn(email: String, password: String,
               onSuccess: (currentUser: FirebaseUser) -> Unit, onFailure: (msg: String?) -> Unit) {
        authHelper.signIn(email, password, onSuccess, onFailure)
    }
}