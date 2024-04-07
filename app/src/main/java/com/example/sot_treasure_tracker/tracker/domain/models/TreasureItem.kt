package com.example.sot_treasure_tracker.tracker.domain.models


interface TreasureItem {
    val nameId: Int
    val price: Price
    val emissaryValue: Int
    val belongsTo: SellFractions
    var quantity: Int
}