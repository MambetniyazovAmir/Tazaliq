package com.example.tazaliq.data.firebase

import com.example.tazaliq.data.model.FAQ
import com.google.firebase.firestore.FirebaseFirestore

class AboutHelper(private val db: FirebaseFirestore) {
    fun getAboutQuestions(onSuccess: (List<FAQ>)->Unit, onFailure: (msg: String?) -> Unit) {
        db.collection("about").get()
            .addOnSuccessListener {
                onSuccess.invoke(it.documents.map { doc->
                    doc.toObject(FAQ::class.java)!!
                })
            }
            .addOnFailureListener {
                onFailure.invoke(it.localizedMessage)
            }
    }
}