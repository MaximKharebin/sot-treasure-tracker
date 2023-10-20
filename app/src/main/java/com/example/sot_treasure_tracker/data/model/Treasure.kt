package com.example.sot_treasure_tracker.data.model


data class Treasure (
    val name: Int,
    val price: Price,
    val emissaryValue: Int,
    val canSellTo: List<Fraction>,
    var quantity: Int = 0
)