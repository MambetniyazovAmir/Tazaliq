package com.example.tazaliq.data.firebase

import android.util.Log
import com.example.tazaliq.data.model.City
import com.example.tazaliq.data.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions

class ProfileHelper(private val auth: FirebaseAuth, private val db: FirebaseFirestore) {
    fun addUserToDB(user: FirebaseUser, onSuccess: ()->Unit, onFailure: (msg: String?)->Unit) {
        db.collection("users")
            .document(user.uid)
            .set(User(id = user.uid))
            .addOnSuccessListener {
                onSuccess.invoke()
            }
            .addOnFailureListener {
                onFailure.invoke(it.localizedMessage)
            }
    }

    fun getUser(onSuccess: (user: User) -> Unit, onFailure: (msg: String?) -> Unit) {
        auth.currentUser?.let { currentUser->
            db.collection("users").document(currentUser.uid).get()
                .addOnSuccessListener { document ->
                    val user = document.toObject(User::class.java)
                    try {
                        user?.let {
                            onSuccess.invoke(it)
                        } ?: onFailure.invoke("Пользователь не существует")
                    } catch (e: Exception) {
                        onFailure.invoke(e.localizedMessage)
                        Log.d("GetUserException", e.localizedMessage!!)
                    }
                }
                .addOnFailureListener {
                    onFailure.invoke(it.localizedMessage)
                }
        }
    }
 
    fun editProfile(name: String, cityId: String, status: String, about: String,
        onSuccess: () -> Unit, onFailure: (msg: String?) -> Unit) {
        val user = hashMapOf("name" to name, "city" to cityId,
            "status" to status, "about" to about)
        db.collection("users").document(auth.currentUser!!.uid)
            .set(user, SetOptions.merge())
            .addOnSuccessListener {
                onSuccess.invoke()
            }
            .addOnFailureListener {
                onFailure.invoke(it.localizedMessage)
            }
    }
}