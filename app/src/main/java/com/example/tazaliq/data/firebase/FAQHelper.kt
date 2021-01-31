package com.example.tazaliq.data.firebase

import com.example.tazaliq.data.model.FAQ
import com.google.firebase.firestore.FirebaseFirestore

class FAQHelper(private val db: FirebaseFirestore) {
    fun getFrequentQuestions(onSuccess: (List<FAQ?>) -> Unit, onFailure: (msg: String?) -> Unit) {
        db.collection("faq").get()
            .addOnSuccessListener {
                onSuccess.invoke(it?.documents?.map { doc -> doc.toObject(FAQ::class.java) } ?: listOf<FAQ>())
            }
            .addOnFailureListener {
                onFailure.invoke(it.localizedMessage)
            }
    }
}