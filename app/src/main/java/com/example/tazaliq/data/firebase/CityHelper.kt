package com.example.tazaliq.data.firebase

import com.example.tazaliq.data.model.City
import com.google.firebase.firestore.FirebaseFirestore

class CityHelper(private val db: FirebaseFirestore) {
    fun getAllCities(onSuccess: (cities: List<City?>) -> Unit, onFailure: (msg: String?) -> Unit) {
        db.collection("cities").get()
            .addOnSuccessListener { snapshot ->
                if (snapshot.documents.isNotEmpty()) {
                    onSuccess.invoke(snapshot.documents.map { doc ->
                        doc.toObject(City::class.java)
                    })
                } else {
                    onSuccess.invoke(listOf())
                }
            }
            .addOnFailureListener {
                onFailure.invoke(it.localizedMessage)
            }
    }
}