package com.example.tazaliq.data.model

data class FAQ (
    val id: String = "",
    val question: String = "",
    val answer: String = "",
    var isOpened: Boolean = false
)