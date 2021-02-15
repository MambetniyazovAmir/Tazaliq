package com.example.tazaliq.data.firebase

import com.example.tazaliq.data.model.User
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query

class RatingHelper(private val db: FirebaseFirestore) {
    fun getChampionUsers(onSuccess: (List<User>)->Unit, onFailure: (String?) -> Unit) {
        db.collection("users").orderBy("quantity", Query.Direction.ASCENDING)
            .get()
            .addOnSuccessListener {
                onSuccess.invoke(it.documents.map { doc -> doc.toObject(User::class.java)!! })
            }
            .addOnFailureListener {
                onFailure.invoke(it.localizedMessage)
            }
    }

    fun getChampionCompanies(onSuccess: (List<User>)->Unit, onFailure: (String?) -> Unit) {
        db.collection("companies").orderBy("quantity", Query.Direction.ASCENDING)
            .get()
            .addOnSuccessListener {
                onSuccess.invoke(it.documents.map { doc -> doc.toObject(User::class.java)!! })
            }
            .addOnFailureListener {
                onFailure.invoke(it.localizedMessage)
            }
    }
}