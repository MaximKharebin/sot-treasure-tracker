package com.example.sot_treasure_tracker.domain.models


interface TreasureItem : CategoryItem {
    val price: Price
    val emissaryValue: Int
    val belongsTo: SellBuckets
}