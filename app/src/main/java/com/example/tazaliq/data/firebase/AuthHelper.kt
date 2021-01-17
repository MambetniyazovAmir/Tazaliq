package com.example.tazaliq.data.firebase

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class AuthHelper(private val auth: FirebaseAuth) {

    fun signIn(email: String, password: String,
              onSuccess: (currentUser: FirebaseUser) -> Unit, onFailure: (msg: String?) -> Unit) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener {  result ->
                result.user?.let { onSuccess.invoke(it) } ?: onFailure.invoke("Failure while signing in")
            }
            .addOnFailureListener { e->
                onFailure.invoke(e.localizedMessage)
            }
    }

    fun signUp(email: String, password: String, onSuccess: (currentUser: FirebaseUser) -> Unit, onFailure: (msg: String?) -> Unit) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener {  result ->
                result.user?.let { onSuccess.invoke(it) } ?: onFailure.invoke("Failure while signing in")
            }
            .addOnFailureListener { e->
                onFailure.invoke(e.localizedMessage)
            }
    }

}