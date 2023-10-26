package com.example.sot_treasure_tracker.data.model

import com.example.sot_treasure_tracker.model.Fraction


data class Treasure (
    val name: Int,
    val price: Price,
    val emissaryValue: Int,
    val canSellTo: List<Fraction>,
    var quantity: Int = 0
)