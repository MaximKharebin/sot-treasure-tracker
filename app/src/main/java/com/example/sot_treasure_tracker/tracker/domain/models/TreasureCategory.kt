package com.example.sot_treasure_tracker.calculator.domain.models

interface TreasureCategory {
    val titleId: Int
    val items: List<TreasureItem>
}