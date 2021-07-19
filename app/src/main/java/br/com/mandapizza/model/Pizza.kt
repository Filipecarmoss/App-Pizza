package br.com.mandapizza.model

data class Pizza(
    val id: String,
    val imageUrl: String,
    val name: String,
    val priceG: Double,
    val priceM: Double,
    val priceP: Double,
    val rating: Double
)