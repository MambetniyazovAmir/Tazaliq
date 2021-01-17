package com.example.tazaliq.data.model

data class User(
    var id: String = "",
    var name: String = "",
    var status: String = "",
    var about: String = "",
    var city: City? = null
)