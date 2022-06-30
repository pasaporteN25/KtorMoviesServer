package com.example.modules

import kotlinx.serialization.Serializable

@Serializable
data class Bands(
    val id: Int,
    val name: String,
    val totalMembers: Int,
    val image: String,
    val about: String,
    val rating: Double,
    val active: Boolean,
    val albums: List<String>
)
