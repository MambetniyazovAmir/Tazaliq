package com.example.tazaliq.data.firebase

import com.google.firebase.firestore.FirebaseFirestore
import java.util.*

class EcoBoxHelper(private val db: FirebaseFirestore) {
    fun addEcoBox(companyName: String, name: String, phone: String, address: String,
                  onSuccess: (String)->Unit, onFailure: (String?)->Unit) {
        val id = UUID.randomUUID().toString()
        val ecoBox = hashMapOf("id" to id, "company_name" to companyName, "name" to name, "phone" to phone, "address" to address)
        db.collection("ecoboxes").document(id).set(ecoBox)
            .addOnSuccessListener {
                onSuccess.invoke("Success")
            }
            .addOnFailureListener {
                onFailure.invoke(it.localizedMessage)
            }

    }
}