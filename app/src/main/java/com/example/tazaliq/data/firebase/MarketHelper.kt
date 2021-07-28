package com.example.tazaliq.data.firebase

import com.example.tazaliq.data.model.Product
import com.google.firebase.firestore.FirebaseFirestore

class MarketHelper(private val db: FirebaseFirestore) {
    fun getProducts(onSuccess: (List<Product>) -> Unit, onFailure: (String?) -> Unit) {
        db.collection("products").get()
            .addOnSuccessListener {
                val products: MutableList<Product> = mutableListOf()
                it.documents.forEach { doc ->
                    products.add(doc.toObject(Product::class.java)!!)
                }
                onSuccess.invoke(products)
            }
            .addOnFailureListener {
                onFailure.invoke(it.localizedMessage)
            }
    }
}