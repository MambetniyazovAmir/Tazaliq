package com.example.tazaliq.ui.auth.registration

import androidx.lifecycle.ViewModel
import com.example.tazaliq.data.firebase.AuthHelper
import com.example.tazaliq.data.firebase.ProfileHelper
import com.google.firebase.auth.FirebaseUser

class RegistrationViewModel(
    private val authHelper: AuthHelper,
    private val profileHelper: ProfileHelper
    ) : ViewModel() {

    fun signUp(email: String, password: String,
               onSuccess: (currentUser: FirebaseUser) -> Unit, onFailure: (msg: String?) -> Unit) {
        authHelper.signUp(email, password, onSuccess, onFailure)
    }

    fun addUserToRemoteDB(user: FirebaseUser, onSuccess:()->Unit, onFailure: (msg: String?) -> Unit) {
        profileHelper.addUserTDB(user, onSuccess, onFailure)
    }
}