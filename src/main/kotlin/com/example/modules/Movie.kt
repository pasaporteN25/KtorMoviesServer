package com.example.modules

import kotlinx.serialization.Serializable

@Serializable
data class Movie(
    val id: Int,
    val title: String,
    val director: String,
    val image: String,
    val about: String,
    val rating: Double,
)