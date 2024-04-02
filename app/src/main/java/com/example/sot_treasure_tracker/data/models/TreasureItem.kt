package com.example.sot_treasure_tracker.data.models

import com.example.sot_treasure_tracker.components.Price
import com.example.sot_treasure_tracker.components.Fraction


data class TreasureItem (
    val name: Int,
    val price: Price,
    val emissaryValue: Int,
    val canSellTo: Fraction,
    var quantity: Int = 0
)