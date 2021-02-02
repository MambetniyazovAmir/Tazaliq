package com.example.tazaliq.data.model

data class City(
    var id: String,
    var name: String
){
    override fun toString(): String{
        return name
    }
}