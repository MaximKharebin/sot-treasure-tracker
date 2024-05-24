package com.example.sot_treasure_tracker.calculator.domain.models

import com.example.sot_treasure_tracker.components.domain.models.CategoryItem


interface TreasureItem : CategoryItem {
    val price: Price
    val emissaryValue: Int
    val belongsTo: SellBuckets
}