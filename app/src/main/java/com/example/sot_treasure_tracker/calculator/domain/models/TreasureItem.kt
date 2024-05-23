package com.example.sot_treasure_tracker.calculator.domain.models


interface TreasureItem {
    val nameId: Int
    val price: Price
    val emissaryValue: Int
    val belongsTo: SellBuckets
    var quantity: Int
}