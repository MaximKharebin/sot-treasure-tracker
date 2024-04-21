package com.example.sot_treasure_tracker.util.domain.models

import com.example.sot_treasure_tracker.calculator.domain.models.SellFractions


interface TreasureItem {
    val nameId: Int
    val price: Price
    val emissaryValue: Int
    val belongsTo: SellFractions
    var quantity: Int
}